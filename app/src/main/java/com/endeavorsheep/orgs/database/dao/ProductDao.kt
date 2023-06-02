package com.endeavorsheep.orgs.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.endeavorsheep.orgs.model.Product

@Dao
interface ProductDao {

    @Query("SELECT * FROM Product")
    fun searchAll(): List<Product>

    @Insert
    fun save(vararg product: Product)

}

/**
 * The vararg property is used to declare a function parameter that accepts a variable number of
 * arguments of the same type. It allows you to pass an arbitrary number of arguments
 * to the function without having to wrap them in a list or matrix.
 */