package com.proway.projeto001.`interface`

import com.proway.projeto001.model.Product

interface ClickableItem {

    fun onClickDelete(position: Int, product: Product)
    fun onClickEdit(product: Product)
}