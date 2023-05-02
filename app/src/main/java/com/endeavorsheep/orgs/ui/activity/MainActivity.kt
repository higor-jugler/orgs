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
import com.endeavorsheep.orgs.dao.ProductsDao
import com.endeavorsheep.orgs.model.Product
import com.endeavorsheep.orgs.ui.recyclerview.adapter.ProductListAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.math.BigDecimal

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onResume() {
        super.onResume()
        // Hide support bar
        supportActionBar?.hide()

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_product_list)
        val productsDao = ProductsDao()
        recyclerView.adapter = ProductListAdapter(
            this, productsDao.searchAll()
        )
        val buttonAdd = findViewById<FloatingActionButton>(R.id.floating_action_button)
        buttonAdd.setOnClickListener {
            startActivity(Intent(this, ProductFormActivity::class.java))
        }
    }
}