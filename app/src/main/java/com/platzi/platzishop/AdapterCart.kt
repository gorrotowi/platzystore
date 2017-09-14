package com.platzi.platzishop

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.find

class AdapterCart(val data: List<Itemlanding>) : RecyclerView.Adapter<AdapterCart.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): Holder =
            Holder(AnkoItemCart().createView(AnkoContext.Companion.create(parent!!.context, this, false)))
    //Holder(LayoutInflater.from(parent?.context).inflate(R.layout.item_cart, parent, false))


    override fun onBindViewHolder(holder: Holder?, position: Int) {
        holder?.bindView(data = data[position])
    }

    override fun getItemCount(): Int = data.size

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val imgV: ImageView by lazy {
            itemView.find<ImageView>(R.id.imgAnkoItem)
        }
        val txttitle: TextView by lazy {
            itemView.find<TextView>(R.id.txtAnkoItemTitle)
        }

        val txtdesc by lazy {
            itemView.find<TextView>(R.id.txtAnkoItemDesc)
        }

        val txtprice by lazy {
            itemView.find<TextView>(R.id.txtAnkoItemPrice)
        }

        fun bindView(data: Itemlanding) {
            with(data) {
                txttitle.text = title
                txtdesc.text = desc
                txtprice.text = "$ ${String.format("%.2f", price)}"
                if (img.isEmpty()) {
                    imgV.setImageResource(R.drawable.shoe_placeholder)
                } else {
                    imgV.loadUrl(img)
                }
            }

        }
    }
}