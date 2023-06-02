package com.endeavorsheep.orgs.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.endeavorsheep.orgs.R
import com.endeavorsheep.orgs.databinding.ProductListBinding
import com.endeavorsheep.orgs.model.Product
import java.text.NumberFormat
import java.util.Locale

class ProductListAdapter(
    private val context: Context,
    products: List<Product>,
    var whenClickOnItem: (product: Product) -> Unit = {}
) : RecyclerView.Adapter<ProductListAdapter.ViewHolder>() {

    private val products = products.toMutableList()

    inner class ViewHolder(private val binding: ProductListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private lateinit var product: Product

        init {
            itemView.setOnClickListener {
                if (::product.isInitialized) {
                    whenClickOnItem(product)
                }
            }
        }

        fun bind(product: Product) {
            this.product = product
            val name = binding.textName
            name.text = product.name
            val description = binding.textDescription
            description.text = product.description
            val price = binding.textPrice
            val currencyInstance: NumberFormat = NumberFormat
                .getCurrencyInstance(Locale("pt", "br"))
            val formatPrice: String = currencyInstance.format(product.price)
            price.text = formatPrice
            // Resource of Coil
            binding.imageViewProduct.load(product.image) {
                error(R.drawable.erro)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): ProductListAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val binding = ProductListBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductListAdapter.ViewHolder, position: Int) {
        val product = products[position]
        holder.bind(product)
    }

    override fun getItemCount(): Int = products.size

    fun refresh(product: List<Product>) {
        this.products.clear()
        this.products.addAll(product)
        notifyDataSetChanged()
    }
}

/**
 * In Kotlin, an inner class is a class defined inside another class.
 * The main difference between an inner class and a nested class is that an inner class has access
 * to the members of the outer class, including the private members.
 * This allows for a tight association between the outer class and the inner class,
 * where the inner class can access and modify the outer class's members.
 */

/**
 * the :: operator in Kotlin lets you create references to top functions,
 * member functions, and properties, and later call or access them as needed.
 * This is useful in situations where you need to pass a function as an argument
 * to another function, or when you want to work with reflection and code introspection.
 */