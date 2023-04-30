package com.endeavorsheep.orgs.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.endeavorsheep.orgs.R

class ProductFormActivity : AppCompatActivity(R.layout.activity_product_form) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Hide support bar
        supportActionBar?.hide()

    }
}