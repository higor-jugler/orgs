package com.endeavorsheep.orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.endeavorsheep.orgs.dao.ProductsDao
import com.endeavorsheep.orgs.databinding.ActivityProductListBinding
import com.endeavorsheep.orgs.ui.recyclerview.adapter.ProductListAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ProductListActivity : AppCompatActivity() {
    
    private val productsDao = ProductsDao()
    private val startAdapter = ProductListAdapter(this, productsDao.searchAll())
    private val binding by lazy {
        ActivityProductListBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setRecyclerView()
        setFab()
    }

    override fun onResume() {
        super.onResume()
        // Hide support bar
        supportActionBar?.hide()
        startAdapter.refresh(productsDao.searchAll())

    }

    /**
     * Create and instantiate the recycler view method
     */
    private fun setRecyclerView() {
        val recyclerView = binding.recyclerProductList
        recyclerView.adapter = startAdapter
    }

    /**
     * Configure all Floating Action Button method
     */
    private fun setFab() {
        val buttonAdd = binding.floatingActionButton
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