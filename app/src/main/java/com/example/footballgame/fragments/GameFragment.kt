package com.example.footballgame.fragments

import android.annotation.SuppressLint

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.navigation.findNavController
import com.example.footballgame.R
import com.example.footballgame.databinding.GameFragmentBinding
import java.util.*

class GameFragment: Fragment() {
    private var _binding: GameFragmentBinding? = null
    private val binding get() = _binding!!
    private var count_3 = 0
    private var timer_state = false
    val count = MutableLiveData(0)

    companion object{
        private var time = "00:00"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = GameFragmentBinding.inflate(inflater, container, false)

        val animation = binding.ballImage.drawable as AnimationDrawable
        countTouches(count, binding.ball, animation)
        binding.backpressBtn.setOnClickListener {
            it.findNavController().popBackStack()
        }
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        binding.timer.text = time
    }

    override fun onStop() {
        super.onStop()
        time = binding.timer.text.toString()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        time = "00:00"
        _binding = null
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    fun countTouches(count: MutableLiveData<Int>, ball: View, animation: AnimationDrawable) {
        val animationList = listOf(
            R.drawable.ball_2_state,
            R.drawable.ball_3_state,
            R.drawable.ball_4_state,
            R.drawable.ball_5_state,
            R.drawable.ball_6_state,
            R.drawable.ball_7_state,
            R.drawable.ball_8_state,
            R.drawable.ball_9_state,
            R.drawable.ball_10_state,
            R.drawable.ball_11_state,
            R.drawable.ball_12_state,
            R.drawable.ball_13_state,
            R.drawable.ball_14_state,
            R.drawable.ball_15_state,
            R.drawable.ball_16_state,
            R.drawable.ball_17_state,
            R.drawable.ball_18_state,
            R.drawable.ball_19_state,
            R.drawable.ball_20_state,
            R.drawable.ball_21_state,
            R.drawable.ball_22_state,
            R.drawable.ball_23_state,
            R.drawable.ball_24_state,
            R.drawable.ball_25_state,
            R.drawable.ball_26_state,
            R.drawable.ball_27_state,
            R.drawable.ball_28_state,
            R.drawable.ball_29_state,
            R.drawable.ball_30_state,
            R.drawable.ball_31_state,
            R.drawable.ball_32_state,
            R.drawable.ball_33_state,
            R.drawable.ball_34_state
        )

        ball.setOnClickListener {
            if (!timer_state){
                binding.timer.base = SystemClock.elapsedRealtime()
                binding.timer.start()
                timer_state = true
            }
            count_3++

            if (count_3==3){
                animation.addFrame(requireContext().getDrawable(animationList[count.value!!])!!,300)
                count.value = count.value?.plus(1)
                animation.run()
                count_3 = 0
            }
        }

        count.observe(viewLifecycleOwner) {
            if (it == animationList.size - 4) {
                stopTimeCount(ball)
                explodeBall(animation, animationList)
            }
        }
    }


    @SuppressLint("UseCompatLoadingForDrawables")
    private fun explodeBall(animation: AnimationDrawable, animationList: List<Int>,){
            animation.addFrame(requireContext().getDrawable(animationList[29])!!, 50)
            animation.addFrame(requireContext().getDrawable(animationList[30])!!, 50)
            animation.addFrame(requireContext().getDrawable(animationList[31])!!, 50)
            animation.addFrame(requireContext().getDrawable(animationList[32])!!, 50)
            animation.run()
            count.value = count.value?.plus(1)
            val dialog = ResultDialog()
            val args = Bundle()
            args.putString("time", binding.timer.text.toString())
            dialog.arguments = args
            dialog.show(activity!!.supportFragmentManager, "EXIT_DIALOG")
    }

    private fun stopTimeCount(ball: View){
        binding.timer.stop()
        timer_state = false
        ball.setOnClickListener { }
    }
}