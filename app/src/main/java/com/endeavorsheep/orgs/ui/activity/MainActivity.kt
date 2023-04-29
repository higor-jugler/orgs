package com.endeavorsheep.orgs.ui.activity

import android.app.Activity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.endeavorsheep.orgs.R
import com.endeavorsheep.orgs.ui.recyclerview.adapter.ProductListAdapter

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Configure the display of view
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_product_list)
        recyclerView.adapter = ProductListAdapter()
    }

}