package com.example.alphaecosystem.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.alphaecosystem.data.db.Card
import com.example.alphaecosystem.databinding.CardInfoBinding
import com.example.alphaecosystem.presentation.viewholders.CardViewHolder


class CardAdapter: RecyclerView.Adapter<CardViewHolder>() {

    private var data: List<Card?> = emptyList()

    fun setData(data: List<Card>) {
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        return CardViewHolder(
            CardInfoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val item = data.getOrNull(position)
        with(holder.binding){
            bin.text = item?.bin.toString()
            type.text = item?.type
            name.text = item?.name
            emoji.text = item?.emoji
            latitude.text = item?.latitude
            longitude.text = item?.longitude
            nameBank.text = item?.nameBank
            url.text = item?.url
            phone.text = item?.phone
            city.text = item?.city
        }

    }

    override fun getItemCount(): Int = data.size
}

