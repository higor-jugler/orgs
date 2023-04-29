package com.endeavorsheep.orgs

import android.app.Activity
import android.os.Bundle
import android.widget.TextView

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = TextView(this)

        // Configure the display of view
        setContentView(R.layout.activity_main)
    }

}