package com.example.alphaecosystem.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.alphaecosystem.R
import com.example.alphaecosystem.app.App
import com.example.data.db.CardDao
import com.example.alphaecosystem.databinding.FragmentHistorySearchBinding
import com.example.alphaecosystem.presentation.adapters.CardAdapter
import com.example.alphaecosystem.presentation.viewmodels.HistoryViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach


class HistorySearchFragment : Fragment() {

    private var _binding: FragmentHistorySearchBinding? = null
    private val binding get() = _binding!!

    private val cardAdapter = CardAdapter()

    private val vmHistory: HistoryViewModel by viewModels {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                val cardDao: CardDao = (activity?.application as App).db.cardDao()
                return HistoryViewModel(cardDao) as T
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHistorySearchBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerCard.adapter = cardAdapter
        vmHistory.allCard.onEach {
            cardAdapter.setData(it)
            if(it.isNotEmpty()){
                binding.historySearch.visibility = View.VISIBLE
                binding.recyclerCard.visibility = View.VISIBLE
            }
        }
            .launchIn(viewLifecycleOwner.lifecycleScope)

        binding.backBtn.setOnClickListener{
            findNavController().navigate(R.id.searchByBinFragment)
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}