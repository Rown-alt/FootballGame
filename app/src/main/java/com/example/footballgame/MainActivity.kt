package com.example.footballgame

import android.annotation.SuppressLint
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.lifecycle.MutableLiveData

class MainActivity : AppCompatActivity() {

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val imageView: ImageView = this.findViewById(R.id.imageView)
        val animation = imageView.drawable as AnimationDrawable
        val animationList = listOf(R.drawable.ball_2_state, R.drawable.ball_3_state, R.drawable.ball_4_state,R.drawable.ball_5_state,
            R.drawable.ball_6_state,R.drawable.ball_7_state,R.drawable.ball_8_state,R.drawable.ball_9_state,R.drawable.ball_10_state,
            R.drawable.ball_11_state, R.drawable.ball_12_state, R.drawable.ball_13_state,R.drawable.ball_14_state,
            R.drawable.ball_15_state,R.drawable.ball_16_state,R.drawable.ball_17_state,R.drawable.ball_18_state,R.drawable.ball_19_state,)
        val count = MutableLiveData(0)

        count.observe(this){
            if (it==18){
                Log.d("ballSize", "max")
                imageView.setOnClickListener {
                }

            }
        }

        imageView.setOnClickListener {
            if (count.value!! <=18){
                animation.addFrame(getDrawable(animationList[count.value!!])!!, 200)
                animation.run()
                count.value = 1 + count.value!!
            }
        }
        }
}