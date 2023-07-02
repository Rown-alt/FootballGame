package com.example.footballgame.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.footballgame.R
import com.example.footballgame.databinding.MenuFragmentBinding

class MenuFragment: Fragment() {
    private var _binding: MenuFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MenuFragmentBinding.inflate(inflater, container, false)
        binding.startBtn.setOnClickListener{
            it.findNavController().navigate(MenuFragmentDirections.actionMenuFragmentToGameFragment())
        }
        binding.resultBtn.setOnClickListener{
            it.findNavController().navigate(MenuFragmentDirections.actionMenuFragmentToResultFragment())
        }
        binding.politicBtn.setOnClickListener{
            it.findNavController().navigate(MenuFragmentDirections.actionMenuFragmentToPoliticFragment())
        }
        binding.quitBtn.setOnClickListener{
            val dialog = ExitDialog()
            dialog.show(activity!!.supportFragmentManager, "EXIT_DIALOG")
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}