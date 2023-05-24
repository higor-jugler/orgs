package com.endeavorsheep.orgs.ui.dialog

import android.content.Context
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import com.endeavorsheep.orgs.databinding.ImageFormBinding
import com.endeavorsheep.orgs.extensions.tryToLoad

class ImageFormDialog(private val context: Context) {

    fun showDialog(
        urlStandard: String? = null,
        waitLoadImage: (image: String) -> Unit
    ) {
        ImageFormBinding
            .inflate(LayoutInflater.from(context)).apply {

                urlStandard?.let {
                    imageForm.tryToLoad(it)
                    textInputEditFormUrl.setText(it)
                }

                buttonForm.setOnClickListener {
                    val url = textInputEditFormUrl.text.toString()
                    imageForm.tryToLoad(url)
                }
                AlertDialog.Builder(context)
                    .setView(root)
                    .setPositiveButton("Confirmar") { _, _ ->
                        val url = textInputEditFormUrl.text.toString()
                        waitLoadImage(url)
                    }
                    .setNegativeButton("Cancelar") { _, _ ->
                    }
                    .show()
            }
    }
}