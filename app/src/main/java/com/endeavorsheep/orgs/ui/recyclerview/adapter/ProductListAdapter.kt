package com.endeavorsheep.orgs.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.endeavorsheep.orgs.R
import com.endeavorsheep.orgs.databinding.ProductListBinding
import com.endeavorsheep.orgs.model.Product
import java.text.NumberFormat
import java.util.*

class ProductListAdapter(
    private val context: Context,
    products: List<Product>
) : RecyclerView.Adapter<ProductListAdapter.ViewHolder>() {
    private val products = products.toMutableList()

    class ViewHolder(private val binding: ProductListBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(product: Product) {
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
        parent: ViewGroup,
        viewType: Int
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
