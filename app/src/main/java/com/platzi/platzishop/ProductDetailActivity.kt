package com.platzi.platzishop

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_product_detail.*
import kotlinx.android.synthetic.main.content_product.*
import org.jetbrains.anko.startActivity

class ProductDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        toolbar.title = ""
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        intent?.extras?.let {
            txtProductTitle.text = it.getString("title")
            txtProductDesc.text = it.getString("desc")
            txtProductPrice.text = "$${it.getDouble("price")}"
        }

        fabProduct.setOnClickListener {
            startActivity<CartActivity>()
        }

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

}
