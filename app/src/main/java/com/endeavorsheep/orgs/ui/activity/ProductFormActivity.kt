package com.endeavorsheep.orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.endeavorsheep.orgs.R
import com.endeavorsheep.orgs.dao.ProductsDao
import com.endeavorsheep.orgs.databinding.ActivityProductFormBinding
import com.endeavorsheep.orgs.databinding.ActivityProductListBinding
import com.endeavorsheep.orgs.databinding.ImageFormBinding
import com.endeavorsheep.orgs.model.Product
import java.math.BigDecimal

class ProductFormActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityProductFormBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.imageProduct.setOnClickListener {
            val formBinding = ImageFormBinding.inflate(layoutInflater)
            formBinding.buttonForm.setOnClickListener {
                val url = formBinding.textInputEditFormUrl.text.toString()
                formBinding.imageForm.load(url)
            }

            AlertDialog.Builder(this)
                .setView(formBinding.root)
                .setPositiveButton("Confirmar") { _, _ ->
                    val url = formBinding.textInputEditFormUrl.text.toString()
                    binding.imageProduct.load(url)
                }
                .setNegativeButton("Cancelar") { _, _ ->
                }
                .show()
        }
    }

    override fun onResume() {
        super.onResume()
        // Hide support bar
        supportActionBar?.hide()
        // Action for button save
        val buttonSave = binding.buttonSave
        setButtonSave(buttonSave)
    }

    private fun setButtonSave(buttonSave: Button) {
        buttonSave.setOnClickListener {
            // Field Name
            val fieldName = binding.textInputEditName
            val name = fieldName.text.toString()
            // Field Description
            val fieldDescription = binding.textInputEditDescription
            val description = fieldDescription.text.toString()
            // Field Price
            val fieldPrice = binding.textInputEditPrice
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