package com.endeavorsheep.orgs.extensions

import android.widget.ImageView
import coil.load
import com.endeavorsheep.orgs.R

fun ImageView.tryToLoad(url: String? = null) {

    load(url) {
        fallback(R.drawable.erro)
        error(R.drawable.erro)
        placeholder(R.drawable.placeholder)
    }

}
