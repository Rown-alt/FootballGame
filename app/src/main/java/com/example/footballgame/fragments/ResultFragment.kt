package com.example.footballgame.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.footballgame.adapters.ResultAdapter
import com.example.footballgame.databinding.ResultFragmentBinding
import com.example.footballgame.viewModels.ResultViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ResultFragment: Fragment() {
    private var _binding: ResultFragmentBinding? = null
    private val binding get() = _binding!!
    private val resultAdapter = ResultAdapter()
    private val resultViewModel by viewModel<ResultViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ResultFragmentBinding.inflate(inflater, container, false)
        binding.backpressBtn.setOnClickListener {
            it.findNavController().popBackStack()
        }
        resultViewModel.getResults()
        resultViewModel.results.observe(viewLifecycleOwner){
            resultAdapter.setResults(it)
        }
        binding.resultRv.adapter = resultAdapter
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}