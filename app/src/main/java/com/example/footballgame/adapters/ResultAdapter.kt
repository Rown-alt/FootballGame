package com.example.footballgame.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.data.TimeResult
import com.example.footballgame.databinding.ResultItemBinding

class ResultAdapter: RecyclerView.Adapter<ResultAdapter.ResultViewHolder>() {
    private var results: List<TimeResult> = mutableListOf()

    class ResultViewHolder(binding: ResultItemBinding): RecyclerView.ViewHolder(binding.root) {
        private val resultName = binding.name
        private val resultTime = binding.result
        fun bind(result: TimeResult){
            resultName.text = result.resultName
            resultTime.text = result.resultTime
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultViewHolder {
        val view = ResultItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ResultViewHolder(view)
    }

    override fun onBindViewHolder(holder: ResultViewHolder, position: Int) {
        holder.bind(results[position])
    }

    override fun getItemCount(): Int {
        return results.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setResults(results: List<TimeResult>){
        this.results = results
        notifyDataSetChanged()
    }
}