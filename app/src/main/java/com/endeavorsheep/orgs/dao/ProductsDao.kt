package com.endeavorsheep.orgs.dao

import com.endeavorsheep.orgs.model.Product

class ProductsDao {

    private val products = mutableListOf<Product>()

    fun addProduct(product: Product) {
        products.add(product)
    }

    fun searchAll(): List<Product> {
        return products
    }
}