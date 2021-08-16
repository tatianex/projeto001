package com.proway.projeto001.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.proway.projeto001.R
import com.proway.projeto001.adapter.GenericAdapter
import com.proway.projeto001.endpoint.RetrofitBuilder
import com.proway.projeto001.model.Product
import com.proway.projeto001.model.TipoLista
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ProductListFragment : Fragment(), Callback<List<Product>> {

    lateinit var recyclerView: RecyclerView

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
        loadProducts()
    }

    private fun loadProducts() {
        val callProduct = RetrofitBuilder.getProductServiceInstance().getAllProducts()
        callProduct.enqueue(this)
    }

    private fun loadComponents(view: View) {

        recyclerView = view.findViewById(R.id.productRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }

    override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
        response.body()?.apply {
            recyclerView.adapter = GenericAdapter(this, TipoLista.PRODUCTS)
        }
    }

    override fun onFailure(call: Call<List<Product>>, t: Throwable) {
        println("Sorry, we could not find any product.")
    }

}