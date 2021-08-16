package com.proway.projeto001.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.proway.projeto001.R
import com.proway.projeto001.endpoint.RetrofitBuilder
import com.proway.projeto001.model.Product
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ProductListFragment : Fragment(), Callback<Product> {

    lateinit var titleTextView: TextView
    lateinit var priceTextView: TextView

    companion object {
        fun newInstance() = ProductListFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.product_fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadComponents(view)
        loadProduct()
    }

    private fun loadProduct() {
        val callProduct = RetrofitBuilder.getProductServiceInstance().getProduct()
        callProduct.enqueue(this)
    }

    private fun loadComponents(view: View) {
        titleTextView = view.findViewById(R.id.titleTextView)
        priceTextView = view.findViewById(R.id.priceTextView)
    }

    override fun onResponse(call: Call<Product>, response: Response<Product>) {
        response.body()?.apply {
            titleTextView.text = title
            priceTextView.text = price.toString()
        }
    }

    override fun onFailure(call: Call<Product>, t: Throwable) {
        //Toast.makeText(this, "Sorry we could not find the product", Toast.LENGTH_LONG).show()
    }
}