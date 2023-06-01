package com.endeavorsheep.orgs.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.endeavorsheep.orgs.databinding.ActivityDetailScreensBinding
import com.endeavorsheep.orgs.extensions.formatPrice
import com.endeavorsheep.orgs.extensions.tryToLoad
import com.endeavorsheep.orgs.model.Product

class DetailScreensActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityDetailScreensBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        loadProduct()
    }

    private fun loadProduct() {
        intent.getParcelableExtra<Product>(KEY_PRODUCT)?.let { productLoaded ->
            fillInField(productLoaded)
        } ?: finish()
    }

    private fun fillInField(productLoaded: Product) {
        with(binding) {
            imageDetailScreens.tryToLoad(productLoaded.image)
            textDetailScreensDescription.text = productLoaded.name
            textDetailScreensInfo.text = productLoaded.description
            textDetailScreensPrice.text = productLoaded.price.formatPrice()
        }
    }
}