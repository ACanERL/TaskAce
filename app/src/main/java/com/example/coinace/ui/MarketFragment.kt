package com.example.coinace.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coinace.ViewModel.CoinViewModel
import com.example.coinace.adapter.CoinAdapter
import com.example.coinace.databinding.FragmentMarketBinding
import com.example.coinace.util.DataStatus
import com.example.coinace.util.gone
import com.example.coinace.util.visible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MarketFragment : Fragment() {
    private lateinit var binding: FragmentMarketBinding
    private  val coinViewModel:CoinViewModel by viewModels()
    private val args by navArgs<MarketFragmentArgs>()
    private val coinAdapter by lazy { CoinAdapter(emptyList(), onItemClick = ::OnClick)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentMarketBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            binding.coinRecycler.adapter = coinAdapter
            binding.coinRecycler.layoutManager = LinearLayoutManager(requireContext())

            viewLifecycleOwner.lifecycleScope.launchWhenStarted {
                coinViewModel.coinListState.collect{dataStatus->
                    when (dataStatus) {
                        is DataStatus.Loading -> {
                            // Show loading state
                            progressBar.visible()
                        }
                        is DataStatus.Success -> {
                            // Update UI with coinList data
                            // For example, you can pass the coinList to your adapter to display in RecyclerView
                            progressBar.gone()
                            val coinList = dataStatus.data
                            coinList.forEach {
                                println("30day:"+it.price_change_percentage_30d_in_currency)
                            }

                            coinAdapter.coinList = coinList
                            coinAdapter.notifyDataSetChanged()


                        }
                        is DataStatus.Error -> {
                            // Show error state
                            progressBar.visible()
                        }
                    }
                }
            }
            coinViewModel.fetchData()
        }
    }
    private fun OnClick(coin: CoinViewModel){
        val action=MarketFragmentDirections.actionMarketFragmentToCoinDetailFragment(coin)
        findNavController().navigate(action)
    }
}

