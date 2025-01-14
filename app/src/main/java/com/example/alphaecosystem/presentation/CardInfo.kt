package com.example.alphaecosystem.presentation

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.alphaecosystem.R
import com.example.alphaecosystem.databinding.CardInfoBinding


class CardInfo @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : ConstraintLayout(context, attrs) {
    private var binding: CardInfoBinding

    init {
        val inflatedView =inflate(context, R.layout.card_info, this)
        binding = CardInfoBinding.bind(inflatedView)
    }

    fun setBin(bin: Int) {
        " ${bin.toString().substring(0,4)} ${bin.toString().substring(4)} ...".also { binding.bin.text = it }
    }
    fun setType(type: String) {
        binding.type.text = type
    }
    fun setName(name: String) {
        binding.name.text = name
    }
    fun setEmoji(emoji: String) {
        binding.emoji.text = emoji
    }
    fun setLatitude(latitude: String) {
        binding.latitude.text = latitude
    }
    fun setLongitude(longitude: String) {
        binding.longitude.text = longitude
    }
    fun setNameBank(nameBank: String) {
        binding.nameBank.text = nameBank
    }
    fun setUrl(url: String) {
        binding.url.text = url
    }
    fun setPhone(phone: String) {
        binding.phone.text = phone
    }
    fun setCity(city: String) {
        binding.city.text = city
    }
}