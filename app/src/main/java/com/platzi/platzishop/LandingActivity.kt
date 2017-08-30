package com.platzi.platzishop

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_landing.*

class LandingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing)

        toolbar.title = "Platzi"
        setSupportActionBar(toolbar)

        rcLanding.layoutManager = GridLayoutManager(this, 2) as RecyclerView.LayoutManager
        rcLanding.setHasFixedSize(true)

        val itemsShop = (0..20).map { Itemlanding("Item $it", "Descripcion $it", 200.00, "") }

        val adapter = AdapterLanding(itemsShop)

        rcLanding.adapter = adapter

    }
}
