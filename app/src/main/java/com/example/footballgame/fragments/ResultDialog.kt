package com.example.footballgame.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.footballgame.databinding.ResultDialogBinding
import com.example.footballgame.viewModels.SaveResultViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ResultDialog: DialogFragment() {
    private var _binding: ResultDialogBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModel<SaveResultViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ResultDialogBinding.inflate(inflater, container, false)
        dialog?.window?.setBackgroundDrawableResource(android.R.color.transparent)
        val args = arguments
        binding.time.text = args?.getString("time")
        binding.saveBtn.setOnClickListener {
            val name = binding.nameEt.text.toString()
            val time = binding.time.text.toString()
            if (name!=""){
                viewModel.saveResult(name, time)
            }
            else{
                Toast.makeText(requireContext(), "Enter your name, please", Toast.LENGTH_SHORT).show()
            }
            viewModel.getResults()
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}