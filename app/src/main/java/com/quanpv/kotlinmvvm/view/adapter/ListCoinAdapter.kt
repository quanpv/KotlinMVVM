package com.quanpv.kotlinmvvm.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.quanpv.kotlinmvvm.R
import com.quanpv.kotlinmvvm.model.CoinModel
import com.quanpv.kotlinmvvm.view.base.BaseAdapter
import com.quanpv.kotlinmvvm.view.viewholder.ListCoinViewHolder
import kotlinx.android.synthetic.main.coin_item.view.*

class ListCoinAdapter constructor(list: List<CoinModel>) : BaseAdapter<CoinModel>(list) {

    override fun onCreateViewHolderBase(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        return ListCoinViewHolder(
            LayoutInflater
            .from(parent?.context)
            .inflate(R.layout.coin_item, parent, false))
    }

    override fun onBindViewHolderBase(holder: RecyclerView.ViewHolder?, position: Int) {
        val viewHolder = (holder as ListCoinViewHolder)
        val coin = list[position]
        viewHolder.itemView.txtName.text = coin.name
        viewHolder.itemView.txtPrice.text = coin.priceUsd + "$"
    }

}