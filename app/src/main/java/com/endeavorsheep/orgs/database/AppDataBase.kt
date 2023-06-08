package com.endeavorsheep.orgs.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.endeavorsheep.orgs.database.converter.Converters
import com.endeavorsheep.orgs.database.dao.ProductDao
import com.endeavorsheep.orgs.model.Product

@Database(entities = [Product::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDataBase : RoomDatabase() {
    abstract fun productsDao(): ProductDao
    companion object {
        fun instancy(context: Context) : AppDataBase {
            return Room.databaseBuilder(
                context,
                AppDataBase::class.java,
                "app_orgs.db"

                //This method allows the app to run without checking the
                // exception to block the room from running on the main thread.
                // This method is not recommended because if the room freezes,
                // the entire app will crash.
            ).allowMainThreadQueries()
                .build()
        }
    }
}

/**
 * Database

The code below defines an AppDatabase class to store the database.
The AppDatabase class defines the database configuration and serves as the app's
main access point
to persisted data. The database class must meet these conditions:

The class needs to have a @Database annotation that includes an entities array listing
all data entities associated with the database.

The class needs to be abstract and extend RoomDatabase.

For each DAO class associated with the database, the database class needs to define
an abstract method that takes no arguments and returns an instance of the DAO class.

https://developer.android.com/training/data-storage/room?hl=pt-br
 */