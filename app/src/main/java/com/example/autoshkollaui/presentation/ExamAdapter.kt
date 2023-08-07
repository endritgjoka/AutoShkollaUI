package com.example.autoshkollaui.presentation

import android.view.LayoutInflater

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.autoshkollaui.R
import com.example.autoshkollaui.databinding.ExamCardBinding

class ExamAdapter(val testsList: ArrayList<ExamModel>, val listener: CustomListener):RecyclerView.Adapter<ExamAdapter.MyViewHolder>(){


   private lateinit var examBinding: ExamCardBinding

//    public fun setSelectListener(selectListener1: SelectListener){
//        selectListener = selectListener1
//    }

    inner class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView), View.OnClickListener{
        var test: TextView
        var percentage: TextView
        var question: TextView
         var card: CardView


        init{
            examBinding = ExamCardBinding.bind(itemView)
            test = itemView.findViewById(R.id.titulli)
            percentage = itemView.findViewById(R.id.permbajtja)
            question = itemView.findViewById(R.id.question)
            card = examBinding.examCard
            itemView.setOnClickListener(this)

        }

        override fun onClick(v: View?) {
            val position = absoluteAdapterPosition
            if (position != RecyclerView.NO_POSITION){
                listener.onItemClicked(position)
            }
        }
    }

    interface CustomListener{
        fun onItemClicked(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var v = LayoutInflater.from(parent.context).
        inflate(R.layout.exam_card, parent, false)
        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return testsList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.test.setText(testsList[position].testNumber)
        holder.percentage.setText(testsList[position].percentage)
        holder.question.setText(testsList[position].question)
        holder.card.setOnClickListener {
            listener.onItemClicked(position)
        }
    }


}