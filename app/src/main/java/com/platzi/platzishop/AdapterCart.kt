package com.platzi.platzishop

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_cart.view.*

class AdapterCart(val data: List<Itemlanding>) : RecyclerView.Adapter<AdapterCart.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): Holder =
            Holder(LayoutInflater.from(parent?.context).inflate(R.layout.item_cart, parent, false))

    override fun onBindViewHolder(holder: Holder?, position: Int) {
        holder?.bindView(data = data[position])
    }

    override fun getItemCount(): Int = data.size

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(data: Itemlanding) {
            with(data) {
                itemView.txtItemCartTitle.text = title
                itemView.txtItemCartDesc.text = desc
                itemView.txtItemCartPrice.text = "$ $price"
                if (img.isEmpty()) {
                    itemView.imgItemCart.setImageResource(R.drawable.shoe_placeholder)
                } else {
                    Glide.with(itemView.context).load(img).into(itemView.imgItemCart)
                }
            }

        }
    }
}