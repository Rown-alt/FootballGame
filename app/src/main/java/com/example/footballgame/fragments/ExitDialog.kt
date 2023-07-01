package com.example.footballgame.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.footballgame.databinding.ExitDialogBinding

class ExitDialog: DialogFragment() {
    private var _binding: ExitDialogBinding? = null
    private val binding get() = _binding!!

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ExitDialogBinding.inflate(inflater, container, false)
        dialog?.window?.setBackgroundDrawableResource(android.R.color.transparent)
        binding.noButton.setOnClickListener {
            dialog?.dismiss()
        }
        binding.yesButton.setOnClickListener {
            activity!!.finishAffinity()
        }
        return binding.root
    }

    companion object{
        val TAG = "EXIT_DIALOG"
    }
}