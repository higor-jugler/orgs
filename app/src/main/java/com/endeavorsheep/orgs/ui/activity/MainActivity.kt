package com.endeavorsheep.orgs.ui.activity

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.service.controls.actions.FloatAction
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.endeavorsheep.orgs.R
import com.endeavorsheep.orgs.model.Product
import com.endeavorsheep.orgs.ui.recyclerview.adapter.ProductListAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.math.BigDecimal

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Hide support bar
        supportActionBar?.hide()

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
        val buttonAdd = findViewById<FloatingActionButton>(R.id.floating_action_button)
        buttonAdd.setOnClickListener {
            startActivity(Intent(this, ProductFormActivity::class.java))
        }
    }
}