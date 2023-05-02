package com.endeavorsheep.orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.endeavorsheep.orgs.R
import com.endeavorsheep.orgs.dao.ProductsDao
import com.endeavorsheep.orgs.databinding.ActivityProductListBinding
import com.endeavorsheep.orgs.ui.recyclerview.adapter.ProductListAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ProductListActivity : AppCompatActivity() {
    lateinit var binding: ActivityProductListBinding
    private val productsDao = ProductsDao()
    private val startAdapter = ProductListAdapter(this, productsDao.searchAll())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setRecyclerView()
    }

    override fun onResume() {
        super.onResume()
        // Hide support bar
        supportActionBar?.hide()
        startAdapter.refresh(productsDao.searchAll())
        setFab()
    }

    /**
     * Create and instantiate the recycler view method
     */
    private fun setRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_product_list)
        recyclerView.adapter = startAdapter
    }

    /**
     * Configure all Floating Action Button method
     */
    private fun setFab() {
        val buttonAdd = findViewById<FloatingActionButton>(R.id.floating_action_button)
        sendToActiveForm(buttonAdd)
    }

    /**
     * Enter the next activity
     */
    private fun sendToActiveForm(buttonAdd: FloatingActionButton) {
        buttonAdd.setOnClickListener {
            startActivity(Intent(this, ProductFormActivity::class.java))
        }
    }

}