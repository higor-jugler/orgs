package com.endeavorsheep.orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.endeavorsheep.orgs.R
import com.endeavorsheep.orgs.dao.ProductsDao
import com.endeavorsheep.orgs.databinding.ActivityProductFormBinding
import com.endeavorsheep.orgs.model.Product
import java.math.BigDecimal

class ProductFormActivity : AppCompatActivity() {
    lateinit var binding: ActivityProductFormBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductFormBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        // Hide support bar
        supportActionBar?.hide()
        // Action for button save
        val buttonSave = findViewById<Button>(R.id.button_save)
        setButtonSave(buttonSave)
    }

    private fun setButtonSave(buttonSave: Button) {
        buttonSave.setOnClickListener {
            // Field Name
            val fieldName = findViewById<EditText>(R.id.edit_name)
            val name = fieldName.text.toString()
            // Field Description
            val fieldDescription = findViewById<EditText>(R.id.edit_description)
            val description = fieldDescription.text.toString()
            // Field Price
            val fieldPrice = findViewById<EditText>(R.id.edit_price)
            val convertPrice = fieldPrice.text.toString()
            val price = if (convertPrice.isBlank()) {
                BigDecimal.ZERO
            } else {
                BigDecimal(convertPrice)
            }
            // Assemble product
            initProduct(name, description, price)
        }
    }

    /**
     * Create product
     */
    private fun initProduct(
        name: String,
        description: String,
        price: BigDecimal
    ) {
        val product = Product(name, description, price)
        val productDao = ProductsDao()
        productDao.addProduct(product)
        startActivity(Intent(this, ProductListActivity::class.java))
        finish()
    }
}