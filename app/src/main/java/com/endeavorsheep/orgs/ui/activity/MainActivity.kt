package com.endeavorsheep.orgs.ui.activity

import android.app.Activity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.endeavorsheep.orgs.R
import com.endeavorsheep.orgs.model.Product
import com.endeavorsheep.orgs.ui.recyclerview.adapter.ProductListAdapter
import java.math.BigDecimal

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Configure the display of view
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_product_list)
        recyclerView.adapter = ProductListAdapter(
            this, listOf(
                Product(
                    "Fruit basket",
                    "Orange, pear and papaya",
                    BigDecimal("9.99")
                ),
                Product(
                    "Fruit basket",
                    "Apple, grape and watermelon",
                    BigDecimal("12.99")
                ),
                Product(
                    "Fruit basket",
                    "tangerine, cocoa and beetroot",
                    BigDecimal("5.99")
                )
            )
        )
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

}