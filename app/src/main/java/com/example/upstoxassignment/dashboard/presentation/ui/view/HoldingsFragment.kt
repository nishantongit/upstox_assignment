package com.example.upstoxassignment.dashboard.presentation.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.upstoxassignment.dashboard.presentation.injection.HoldingComponent
import com.example.upstoxassignment.dashboard.presentation.ui.adapter.HoldingsListAdapter
import com.example.upstoxassignment.dashboard.presentation.ui.viewmodel.HoldingViewModelFactory
import com.example.upstoxassignment.dashboard.presentation.ui.viewmodel.HoldingsViewModel
import com.example.upstoxassignment.databinding.FragmentHoldingsBinding
import javax.inject.Inject

class HoldingsFragment : Fragment() {

    companion object {
        fun newInstance() = HoldingsFragment()
    }


    lateinit var viewModel: HoldingsViewModel

    @Inject
    lateinit var viewModelFactory: HoldingViewModelFactory

    private var adapter = HoldingsListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        HoldingComponent.Initializer.init(requireContext()).inject(this)
        viewModel = ViewModelProvider(this, viewModelFactory).get(HoldingsViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentHoldingsBinding =
            FragmentHoldingsBinding.inflate(inflater, container, false)
        binding.vm = viewModel
        binding.holdingRv.adapter = adapter
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.onLoad()

        viewModel.holdingLive.observe(viewLifecycleOwner, Observer {
            //set on UI
            adapter.swapData(it)

        })
    }


}