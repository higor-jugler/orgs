package com.endeavorsheep.orgs.ui.dialog

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import coil.load
import com.endeavorsheep.orgs.databinding.ImageFormBinding

class ImageFormDialog(private val context: Context) {

    fun showDialog() {
        val binding = ImageFormBinding
            .inflate(LayoutInflater.from(context))

        binding.buttonForm.setOnClickListener {
            val url = binding.textInputEditFormUrl.text.toString()
            binding.imageForm.load(url)
        }

        AlertDialog.Builder(context)
            .setView(binding.root)
            .setPositiveButton("Confirmar") { _, _ ->
                val url =
                    binding.textInputEditFormUrl.text.toString()
                Log.i("ImageFormDialog", "show: $url")
            }
            .setNegativeButton("Cancelar") { _, _ ->
            }
            .show()

    }

}