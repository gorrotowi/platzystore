package com.platzi.platzishop

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide

/**
 * @author Gorro
 */
fun Activity.toastshort(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun ViewGroup.inflate(layoutId: Int): View {
    return LayoutInflater.from(context).inflate(layoutId, this, false)
}

//fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false): View {
//    return LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)
//}

fun ImageView.loadUrl(url: String) {
    Glide.with(this.context).load(url).into(this)
}