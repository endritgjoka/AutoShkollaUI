package com.example.autoshkollaui.Fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.autoshkollaui.LiteratureViewActivity
import com.example.autoshkollaui.R
import com.example.autoshkollaui.databinding.FragmentLiteratureBinding
import com.example.autoshkollaui.presentation.LiteratureModel
import com.example.autoshkollaui.presentation.LiteratureAdapter


class LiteratureFragment : Fragment() {

    private lateinit var literatureBinding: FragmentLiteratureBinding
    private lateinit var modelsList: ArrayList<LiteratureModel>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_literature, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        literatureBinding = FragmentLiteratureBinding.bind(view)

        modelsList = ArrayList()

        var recyclerView: RecyclerView = literatureBinding.recycler3
        recyclerView.layoutManager = LinearLayoutManager(requireContext(),
            LinearLayoutManager.VERTICAL, false)

        recyclerView.isNestedScrollingEnabled = false
        recyclerView.setHasFixedSize(false)

        var l1 = LiteratureModel(R.drawable.exam,"Nocionet","Perkufizimi i nocioneve")
        var l2 = LiteratureModel(R.drawable.exam,"Sinjalizimi horizontal","Perkufizimi i nocioneve")
        var l3 = LiteratureModel(R.drawable.exam,"Sinjalizimi vertikal","Perkufizimi i nocioneve")
        var l4 = LiteratureModel(R.drawable.exam,"Shenjat nga personi i autorizuar","Perkufizimi i nocioneve")
        var l5 = LiteratureModel(R.drawable.exam,"Rregullat e trafikut rrugor","Perkufizimi i nocioneve")
        var l6 = LiteratureModel(R.drawable.exam,"Ilustrimet","Perkufizimi i nocioneve")
        var l7 = LiteratureModel(R.drawable.exam,"Shenjat e tabeles se instrumenteve","Perkufizimi i nocioneve")
        var l8 = LiteratureModel(R.drawable.exam,"Poligoni","Perkufizimi i nocioneve")

        modelsList.add(l1)
        modelsList.add(l2)
        modelsList.add(l3)
        modelsList.add(l4)
        modelsList.add(l5)
        modelsList.add(l6)
        modelsList.add(l7)
        modelsList.add(l8)
        modelsList.add(l8)
        modelsList.add(l8)
        modelsList.add(l8)
        modelsList.add(l8)

        initRecyclerView()

        literatureBinding.freeLiterature.setOnClickListener{
            val intent = Intent(requireContext(), LiteratureViewActivity::class.java)
            intent.putExtra("title", literatureBinding.titulli.text.toString())
            startActivity(intent)
        }

    }

    private fun initRecyclerView(){
        literatureBinding.recycler3.apply {
            adapter = LiteratureAdapter(modelsList)
        }
    }
}