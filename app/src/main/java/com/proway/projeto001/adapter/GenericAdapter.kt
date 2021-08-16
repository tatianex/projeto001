package com.proway.projeto001.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.proway.projeto001.R
import com.proway.projeto001.`interface`.ClickableItem
import com.proway.projeto001.model.Product
import com.proway.projeto001.model.TipoLista
import com.proway.projeto001.model.User

class GenericAdapter<T>(private val listOf: List<T>, private val type: TipoLista, val onClickable: ClickableItem):
    RecyclerView.Adapter<GenericViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenericViewHolder {
        val viewProduct = LayoutInflater.from(parent.context).inflate(R.layout.list_product_recycler, parent, false)
        //val viewUser = LayoutInflater.from(parent.context).inflate(R.layout.fragment_detail_user, parent, false)
        return GenericViewHolder(viewProduct)
    }

    override fun onBindViewHolder(holder: GenericViewHolder, position: Int) {
        listOf[position].apply {
            holder.bind(this)
            holder.itemView.setOnClickListener{
                onClickable.onClickDetail(this as Product)
            }
        }
    }

    override fun getItemCount(): Int = listOf.size
}

class GenericViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    private val param1TextView: TextView = itemView.findViewById(R.id.titleTextView)
    private val param2TextView: TextView = itemView.findViewById(R.id.priceTextView)

    fun <T> bind(model: T) {

        when (model) {
            is Product -> {
                param1TextView.text = model.title
                param2TextView.text = model.price.toString()
            }
            is User -> {
                param1TextView.text = model.email
                param2TextView.text = model.password
            }
        }
    }
}