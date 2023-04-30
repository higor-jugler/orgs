package com.endeavorsheep.orgs.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.endeavorsheep.orgs.R

class ProductFormActivity : AppCompatActivity(R.layout.activity_product_form) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Hide support bar
        supportActionBar?.hide()

        // Action for button save
        val buttonSave = findViewById<Button>(R.id.button_save)
        buttonSave.setOnClickListener {
            val name = findViewById<EditText>(R.id.edit_name)
            val toName = name.text.toString()
            Log.i("ActivityProductForm", "onCreate: $toName")
        }
    }
}