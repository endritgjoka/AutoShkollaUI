package com.example.autoshkollaui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.autoshkollaui.databinding.ActivityInstructionsBinding
import com.example.autoshkollaui.presentation.LiteratureAdapter
import com.example.autoshkollaui.presentation.LiteratureModel

class InstructionsActivity : AppCompatActivity() {
    private lateinit var binding : ActivityInstructionsBinding
    private lateinit var instructionsAdapter: LiteratureAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityInstructionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.startTestBtn.setOnClickListener{
            val intent = Intent(this, ExamsFromAPIActivity::class.java)
            startActivity(intent)
            this.finish()
        }

        val recycler: RecyclerView = binding.recyclerInstructions
        recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recycler.setHasFixedSize(false)
        recycler.isNestedScrollingEnabled = false

        var list = ArrayList<LiteratureModel>()

        val obj1 = LiteratureModel(R.drawable.clock_icon,"Kohezgjatja","Kohezgjatja e testit eshte 45 min")
        val obj2 = LiteratureModel(R.drawable.clock_icon,"Permbajta","Testi permban 30 pyetje")
        val obj3 = LiteratureModel(R.drawable.clock_icon,"Kalueshmeria","Kalueshmeria e testit eshte 85%")
        val obj4 = LiteratureModel(R.drawable.clock_icon,"Pyetjet","Pyetjet mund te kene nje, dy ose tre pergjigje te sakta!")

        list.add(obj1)
        list.add(obj2)
        list.add(obj3)
        list.add(obj4)

        instructionsAdapter = LiteratureAdapter(list, R.layout.instruction_card)

        initRecyclerView()

    }

    fun initRecyclerView(){
        binding.recyclerInstructions.apply {
            adapter = instructionsAdapter
        }
    }
}