package com.example.autoshkollaui.presentation


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.autoshkollaui.API.generated_classes.Photo
import com.example.autoshkollaui.R
import com.example.autoshkollaui.databinding.QuestionCardBinding

class CustomAdapter(val modelsList: ArrayList<Photo>, var model : Int = R.layout.question_card):RecyclerView.Adapter<CustomAdapter.MyViewHolder>(){
    private lateinit var  listener : CustomListener
    public fun setSelectListener(selectListener1: CustomListener){
        listener = selectListener1
    }

    //private lateinit var literatureBinding:QuestionCardBinding
    inner class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView), View.OnClickListener{
        var img:ImageView
        var titulli: TextView
        var permbajtja: TextView
      //  var card : CardView

        init{
           // literatureBinding = QuestionCardBinding.bind(itemView)
            img = itemView.findViewById(R.id.imageView)
            titulli = itemView.findViewById(R.id.titulli)
            permbajtja = itemView.findViewById(R.id.permbajtja)
           // card = itemView.findViewById(R.id.questionCard)
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
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
        inflate(this.model, parent, false)
        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return modelsList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Glide.with(holder.img.context)
            .load(modelsList[position].src.original)
            .into(holder.img)
        //holder.img.setImageResource(modelsList[position].src.original)
        holder.titulli.setText(modelsList[position].alt)
        holder.permbajtja.setText(modelsList[position].photographer)
//        holder.card.setOnClickListener{
//            listener.onItemClicked(position)
//        }
    }
}