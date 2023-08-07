package com.example.autoshkollaui.Literature

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.example.autoshkollaui.API.generated_classes.Photo
import com.example.autoshkollaui.R
import com.example.autoshkollaui.presentation.LiteratureModel

class LiteratureViewPagerAdapter():PagerAdapter(){

    private var list = ArrayList<Photo>()

    fun setList(list1:ArrayList<Photo>){
        list.clear()
        list.addAll(list1)

    }
    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val inflater = LayoutInflater.from(container.context)
        val itemView = inflater.inflate(R.layout.literature_view_pager, container, false)

        val imageLiterature = itemView.findViewById<ImageView>(R.id.image_literature)
        val  titleLiterature = itemView.findViewById<TextView>(R.id.titleLiterature)
        val  descriptionLiterature = itemView.findViewById<TextView>(R.id.descriptionLiterature)

        titleLiterature.text = list[position].photographer
        descriptionLiterature.text = list[position].alt
        val imageUrl = list[position].src.original
        Glide.with(itemView.context)
            .load(imageUrl)
            .into(imageLiterature)

//        titleLiterature.text = list[position].titulli
//        descriptionLiterature.text = list[position].permbajtja
//        val imageUrl = R.drawable.profile_male
//        Glide.with(itemView.context)
//            .load(imageUrl)
//            .into(imageLiterature)


        container.addView(itemView)

        return itemView
    }

    override fun destroyItem(container: ViewGroup, position: Int, obj: Any) {
        container.removeView(obj as View)
    }

    override fun getCount(): Int {
        return list.size
    }

    override fun isViewFromObject(view: View, obj: Any): Boolean {
        return view == obj
    }

}