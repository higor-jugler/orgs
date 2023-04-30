package com.endeavorsheep.orgs.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.endeavorsheep.orgs.R
import com.endeavorsheep.orgs.model.Product
import java.math.BigDecimal

class ProductFormActivity : AppCompatActivity(R.layout.activity_product_form) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Hide support bar
        supportActionBar?.hide()

        // Action for button save
        val buttonSave = findViewById<Button>(R.id.button_save)
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
            val product = Product(name, description, price)

            Log.i("ActivityProductForm", "onCreate: $product")
        }
    }
}