package com.platzi.platzishop

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_cart.*

class CartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        rcCart.layoutManager = layoutManager
        rcCart.setHasFixedSize(true)

        val items = arrayListOf<Itemlanding>()

        (0..2).map { items.add(Itemlanding("Item $it", "Desc $it", it + 100.0, "")) }

        rcCart.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
        rcCart.adapter = AdapterCart(items)
    }
}
