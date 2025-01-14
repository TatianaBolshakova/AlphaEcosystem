package com.example.alphaecosystem.presentation.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.alphaecosystem.R
import com.example.alphaecosystem.data.db.App
import com.example.alphaecosystem.data.db.Card
import com.example.alphaecosystem.data.db.CardDao
import com.example.alphaecosystem.databinding.FragmentSearchByBinBinding
import com.example.alphaecosystem.presentation.viewmodels.HistoryViewModel
import com.example.alphaecosystem.presentation.viewmodels.SearchByBinViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.launch

class SearchByBinFragment : Fragment() {

    private val vmSearch: SearchByBinViewModel by viewModels()
    private val vmHistory: HistoryViewModel by viewModels {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                val cardDao: CardDao = (activity?.application as App).db.cardDao()
                return HistoryViewModel(cardDao) as T
            }
        }
    }
    private var _binding: FragmentSearchByBinBinding? = null
    private val binding get() = _binding!!

    private var bin = 0
    private var enterBin = 0
    private lateinit var newCard: Card

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchByBinBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.searchBtn.setOnClickListener{
            enterBin = binding.enterBin.text.toString().toInt()
            if (enterBin.toString().length==8 ) {
                bin = enterBin.toString().toInt()
                vmSearch.loadInfo(bin = bin)
                lifecycleScope.launch{
                    vmSearch.info.take(1).collect {

                       newCard = Card(
                            bin = bin,
                            type = it?.type?: "Type: -",
                            name = it?.country?.name?: "Country: -",
                            emoji = it?.country?.emoji?: "",
                            latitude = "(${it?.country?.latitude};",
                            longitude = "${it?.country?.longitude})",
                            nameBank = it?.bank?.name?: "Bank: -",
                            url = it?.bank?.url?: "Url: -",
                            phone = it?.bank?.phone?: "Phone: -",
                            city = it?.bank?.city?: "City: -"
                        )
                        binding.cardInfo.apply {
                                setBin(newCard.bin)
                                setType(newCard.type)
                                setName(newCard.name)
                                setEmoji(newCard.emoji)
                                setLatitude(newCard.latitude)
                                setLongitude(newCard.longitude)
                                setNameBank(newCard.nameBank)
                                setUrl(newCard.url)
                                setPhone(newCard.phone)
                                setCity(newCard.city)
                        }

                        binding.apply {
                            delay(1000)
                            if (it?.type==null){
                                binding.cardInfo.visibility = View.GONE
                                binding.error.visibility = View.VISIBLE
                            }else{
                                cardInfo.visibility = View.VISIBLE
                                binding.error.visibility = View.GONE
                            }
                        }
                    }
                    lifecycleScope.launch(Dispatchers.IO) {
                        if (newCard.type!="Type: -")
                        vmHistory.addCard(newCard)
                    }
                }
            }else {
                Toast.makeText(requireContext(),"Length no 8 digits",Toast.LENGTH_SHORT).show()
            }
        }
        binding.openHistoryBtn.setOnClickListener{
            findNavController().navigate(R.id.historySearchFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}