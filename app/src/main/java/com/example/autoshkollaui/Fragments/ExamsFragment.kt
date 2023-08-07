package com.example.autoshkollaui.Fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.autoshkollaui.InstructionsActivity
import com.example.autoshkollaui.R
import com.example.autoshkollaui.databinding.FragmentExamsBinding
import com.example.autoshkollaui.presentation.ExamAdapter
import com.example.autoshkollaui.presentation.ExamModel

class ExamsFragment : Fragment(){

    private lateinit var testetFragment: FragmentExamsBinding
    private lateinit var testsList:ArrayList<ExamModel>
    private lateinit var testAdapter: ExamAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_exams, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        testetFragment = FragmentExamsBinding.bind(view)

        val openRandomTest = view.findViewById<Button>(R.id.randomTest)
//        openRandomTest.setOnClickListener{
//            val intent = Intent(requireContext(), MainActivity2::class.java)
//            startActivity(intent)
//        }

        openRandomTest.setOnClickListener{
           val intent = Intent(requireContext(), InstructionsActivity::class.java)
            startActivity(intent)
        }

        val recyclerView: RecyclerView = testetFragment.recycler1
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        recyclerView.isNestedScrollingEnabled = false
        recyclerView.setHasFixedSize(false)

        testsList  = ArrayList()

        for (i in 1..84){
            testsList.add(ExamModel("Test "+i, "20 %","A lejohet qarkullimi i veturave, ne rastin me poshte?"))
        }

         testAdapter = ExamAdapter(testsList, object : ExamAdapter.CustomListener {
            override fun onItemClicked(position: Int) {
                val intent = Intent(requireContext(), InstructionsActivity::class.java)
                startActivity(intent)
            }
        })

        initRecyclerView()
        }

    private fun initRecyclerView(){
        testetFragment.recycler1.apply {
            adapter = testAdapter
        }
    }

}



