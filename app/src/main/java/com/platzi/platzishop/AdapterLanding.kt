package com.platzi.platzishop

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_landing.view.*
import org.jetbrains.anko.startActivity

class AdapterLanding(val data: List<Itemlanding>) : RecyclerView.Adapter<AdapterLanding.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): Holder =
            Holder(LayoutInflater.from(parent?.context).inflate(R.layout.item_landing, parent, false))


    override fun onBindViewHolder(holder: Holder?, position: Int) {
        holder?.bindView(data[position])
    }

    override fun getItemCount(): Int = data.size

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(data: Itemlanding) {

            with(data) {
                itemView.txtItemTitle.text = title
                itemView.txtItemDesc.text = desc
                itemView.txtItemPrice.text = "$ $price"

                itemView.setOnClickListener {
                    Toast.makeText(itemView.context, "Click $title", Toast.LENGTH_SHORT).show()
                    itemView.context.startActivity<ProductDetailActivity>("title" to title, "desc" to desc, "price" to price)
                }

                if (img.isEmpty()) {
                    itemView.imgItem.setImageResource(R.drawable.shoe_placeholder)
                } else {
                    Glide.with(itemView.context).load(img).into(itemView.imgItem)
                }
            }

        }
    }

}