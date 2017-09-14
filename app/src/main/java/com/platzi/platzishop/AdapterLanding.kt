package com.platzi.platzishop

import android.app.Activity
import android.content.Intent
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.util.Pair
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_landing.view.*

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
                itemView.txtItemPrice.text = "\$ ${String.format("%.2f", price)}"

                itemView.setOnClickListener {
                    Toast.makeText(itemView.context, "Click $title", Toast.LENGTH_SHORT).show()
//                    itemView.context.startActivity<ProductDetailActivity>("title" to title, "desc" to desc, "price" to price)
                    val intent = Intent(itemView.context, ProductDetailActivity::class.java)
                    intent.putExtra("title", title)
                    intent.putExtra("desc", desc)
                    intent.putExtra("price", price)
                    val p1: Pair<View, String> = Pair.create(itemView.imgItem, itemView.context.getString(R.string.img_item_cart))
                    val p2: Pair<View, String> = Pair.create(itemView.txtItemTitle, itemView.context.getString(R.string.txt_detail_title))
                    val p3: Pair<View, String> = Pair.create(itemView.txtItemDesc, itemView.context.getString(R.string.txt_detail_desc))
                    val p4: Pair<View, String> = Pair.create(itemView.txtItemPrice, itemView.context.getString(R.string.txt_detail_price))
                    val options = ActivityOptionsCompat.makeSceneTransitionAnimation(itemView.context as Activity, p1, p2, p3, p4)
                    itemView.context.startActivity(intent, options.toBundle())

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