package com.endeavorsheep.orgs

import android.app.Activity
import android.os.Bundle
import android.widget.TextView

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Configure the display of view
        setContentView(R.layout.activity_main)
        val name = findViewById<TextView>(R.id.text_name)
        name.text = "Fruit basket"
        val description = findViewById<TextView>(R.id.text_description)
        description.text = "Apple, pear and grape"
        val price = findViewById<TextView>(R.id.text_price)
        price.text = "$ 8.99"
    }

}