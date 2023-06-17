package com.endeavorsheep.orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.endeavorsheep.orgs.database.AppDataBase
import com.endeavorsheep.orgs.databinding.ActivityProductListBinding
import com.endeavorsheep.orgs.ui.recyclerview.adapter.ProductListAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ProductListActivity : AppCompatActivity() {

    private val startAdapter = ProductListAdapter(this)
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
        supportActionBar?.hide()
        val db = Room.databaseBuilder(
            this,
            AppDataBase::class.java,
            "app_orgs.db"
        ).allowMainThreadQueries()
            .build()
        val productDao = db.productsDao()
        startAdapter.refresh(productDao.searchAll())
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

    /**
     * Create and instantiate the recycler view method
     */
    private fun setRecyclerView() {
        val recyclerView = binding.recyclerProductList
        recyclerView.adapter = startAdapter
        startAdapter.whenClickOnItem = {
            val intent = Intent(
                this,
                DetailScreensActivity::class.java
            ).apply {
                putExtra(KEY_PRODUCT, it)
            }
            startActivity(intent)
        }
    }
}

/**
 * allowMainThreadQueries()
 * This method allows the app to run without checking the
 * exception to block the room from running on the main thread.
 * This method is not recommended because if the room freezes,
 * the entire app will crash.
 */