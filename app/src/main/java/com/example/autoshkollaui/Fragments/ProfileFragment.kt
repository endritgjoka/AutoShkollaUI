package com.example.autoshkollaui.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.example.autoshkollaui.R


class ProfileFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile,container, false)


        val txt1 = view.findViewById<TextView>(R.id.textView01)
        txt1.text = "Endrit Gjokaj"

        val txt2 = view.findViewById<TextView>(R.id.textView121)
        txt2.text = "endritgjokaj14@gmail.com"

        val card = view.findViewById<CardView>(R.id.cardView0)
//        val cardColor = Color.parseColor("#2C2C2A")
//        card.setCardBackgroundColor(cardColor)

        val sign = view.findViewById<TextView>(R.id.sign)

        val image = view.findViewById<ImageView>(R.id.image)
        image.setImageResource(R.drawable.profile)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


}