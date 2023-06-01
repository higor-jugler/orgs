package com.endeavorsheep.orgs.dao

import com.endeavorsheep.orgs.model.Product
import java.math.BigDecimal

class ProductsDao {

    fun addProduct(product: Product) {
        Companion.products.add(product)
    }

    fun searchAll(): List<Product> {
        return Companion.products
    }

    companion object {
        private val products = mutableListOf<Product>(

        )
    }
}