package com.proway.projeto001

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.proway.projeto001.endpoint.RetrofitBuilder
import com.proway.projeto001.model.Product
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailProductActivity : AppCompatActivity(), Callback<Product> {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)
        val productId = intent.getSerializableExtra("id")
        val service = RetrofitBuilder.getProductServiceInstance()
        val call = service.getProduct(productId as Int)
        call.clone().enqueue(this)
    }

    override fun onResponse(call: Call<Product>, response: Response<Product>) {
        response.body()?.let { myProduct ->
            findViewById<ImageView>(R.id.productImageView).apply {
                Glide.with(context).load(myProduct.image).placeholder(R.drawable.ic_launcher_background).into(this)
            }
            findViewById<TextView>(R.id.idTextView).text = myProduct.id.toString()
            findViewById<TextView>(R.id.titleTextView).text = myProduct.title
            findViewById<TextView>(R.id.priceTextView).text = myProduct.price.toString()
            findViewById<TextView>(R.id.categoryTextView).text = myProduct.category
            findViewById<TextView>(R.id.descriptionTextView).text = myProduct.description
        }
    }

    override fun onFailure(call: Call<Product>, t: Throwable) {
        println("Sorry we couldn't find any product")
    }


}