package com.example.autoshkollaui.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.autoshkollaui.R
import com.example.autoshkollaui.databinding.QuestionCardBinding

class LiteratureAdapter(val modelsList: ArrayList<LiteratureModel>, var model : Int = R.layout.question_card):RecyclerView.Adapter<LiteratureAdapter.MyViewHolder>(){

    private lateinit var literatureBinding:QuestionCardBinding
    inner class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var img:ImageView
        var titulli: TextView
        var permbajtja: TextView

        init{
            img = itemView.findViewById(R.id.imageView)
            titulli = itemView.findViewById(R.id.titulli)
            permbajtja = itemView.findViewById(R.id.permbajtja)
        }


    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var v = LayoutInflater.from(parent.context).
        inflate(this.model, parent, false)
        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return modelsList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.img.setImageResource(modelsList[position].imgModel)
        holder.titulli.setText(modelsList[position].titulli)
        holder.permbajtja.setText(modelsList[position].permbajtja)
    }
}