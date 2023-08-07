package com.example.autoshkollaui.Fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.autoshkollaui.QuestionViewActivity
import com.example.autoshkollaui.R
import com.example.autoshkollaui.databinding.FragmentQuestionsBinding
import com.example.autoshkollaui.presentation.LiteratureModel
import com.example.autoshkollaui.presentation.LiteratureAdapter


class QuestionsFragment : Fragment() {


    private lateinit var questionsBinding: FragmentQuestionsBinding
    private lateinit var modelsList:ArrayList<LiteratureModel>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_questions, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        questionsBinding = FragmentQuestionsBinding.bind(view)

        val recyclerView:RecyclerView = questionsBinding.recycler2
        recyclerView.layoutManager = LinearLayoutManager(requireContext(),
            LinearLayoutManager.VERTICAL, false)
        recyclerView.setHasFixedSize(false)
        recyclerView.isNestedScrollingEnabled = false
//
//        val toolbar = activity?.findViewById<TextView>(R.id.titleTxt)
//        toolbar?.text = "Pyetjet"

//        val collapsingToolbarLayout = activity?.findViewById<CollapsingToolbarLayout>(R.id.collapsingToolbarLayout)
//        collapsingToolbarLayout?.title = "Pyetjet" // Set the title here

        modelsList = ArrayList()

        var p1 = LiteratureModel(R.drawable.exam,"Situatat ne trafik"," 0 / 140 pyetje")
        var p2 = LiteratureModel(R.drawable.exam,"Shenjat e trafikut"," 0 / 224 pyetje")
        var p3 = LiteratureModel(R.drawable.exam,"Semaforet"," 0 / 8 pyetje")
        var p4 = LiteratureModel(R.drawable.exam,"Personi i autorizuar"," 0 / 16 pyetje")
        var p5 = LiteratureModel(R.drawable.exam,"Shenjat(shenimet) rrugore"," 0 / 8 pyetje")
        var p6 = LiteratureModel(R.drawable.exam,"Rregullat e trafikut dhe sigurise"," 0 / 440 pyetje")
        var p7 = LiteratureModel(R.drawable.exam,"Kryqezimet"," 0 / 80 pyetje")
        var p8 = LiteratureModel(R.drawable.exam,"Faktoret qe ndikojne ne ngasje, Eko-ngasje dhe "," 0 / 80 pyetje")

        modelsList.add(p1)
        modelsList.add(p2)
        modelsList.add(p3)
        modelsList.add(p4)
        modelsList.add(p5)
        modelsList.add(p6)
        modelsList.add(p7)
        modelsList.add(p8)
        
//        val adapter =
        initRecyclerView()

        questionsBinding.freeQuestion.setOnClickListener{
            val intent = Intent(requireContext(), QuestionViewActivity::class.java)
            startActivity(intent)
        }

    }

    private fun initRecyclerView(){
        questionsBinding.recycler2.apply {
            adapter = LiteratureAdapter(modelsList)
        }
    }



}