package com.endeavorsheep.orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import coil.imageLoader
import coil.load
import com.endeavorsheep.orgs.R
import com.endeavorsheep.orgs.dao.ProductsDao
import com.endeavorsheep.orgs.database.AppDataBase
import com.endeavorsheep.orgs.databinding.ActivityProductFormBinding
import com.endeavorsheep.orgs.databinding.ActivityProductListBinding
import com.endeavorsheep.orgs.databinding.ImageFormBinding
import com.endeavorsheep.orgs.extensions.tryToLoad
import com.endeavorsheep.orgs.model.Product
import com.endeavorsheep.orgs.ui.dialog.ImageFormDialog
import java.math.BigDecimal

class ProductFormActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityProductFormBinding.inflate(layoutInflater)
    }
    private var url: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        title = "Cadastrar produto"
        setButtonSave()
        binding.imageProduct.setOnClickListener {
            ImageFormDialog(this)
                .showDialog(url) { image ->
                    url = image
                    binding.imageProduct.tryToLoad(url)
                }
        }
    }

    override fun onResume() {
        super.onResume()
        // Hide support bar
        supportActionBar?.hide()
        // Action for button save

    }

    private fun setButtonSave() {
        val buttonSave = binding.buttonSave
        val db = AppDataBase.instancy(this)
        val productDao = db.productsDao()
        productDao.save()
        buttonSave.setOnClickListener {
            val newProduct = initProduct()
            productDao.save(newProduct)
            finish()
        }
    }

    /**
     * Create product
     */
    private fun initProduct(): Product {
        val fieldName = binding.textInputEditName
        val name = fieldName.text.toString()
        val fieldDescription = binding.textInputEditDescription
        val description = fieldDescription.text.toString()
        val fieldPrice = binding.textInputEditPrice
        val convertPrice = fieldPrice.text.toString()
        val price = if (convertPrice.isBlank()) {
            BigDecimal.ZERO
        } else {
            BigDecimal(convertPrice)
        }
        return Product(
            name = name,
            description = description,
            price = price,
            image = url
        )
    }
}