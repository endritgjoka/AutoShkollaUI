package com.example.autoshkollaui


import android.graphics.PorterDuff
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.autoshkollaui.databinding.ActivityQuestionViewBinding

class QuestionViewActivity : AppCompatActivity() {

    private lateinit var binding : ActivityQuestionViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.inflate(layoutInflater, R.layout.activity_question_view, null, false)
        setContentView(binding.root)

        val toolbar = binding.toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //Change color of back button
        val upArrow = resources.getDrawable(androidx.constraintlayout.widget.R.drawable.abc_ic_ab_back_material, theme)
        upArrow.setColorFilter(resources.getColor(android.R.color.holo_orange_dark), PorterDuff.Mode.SRC_ATOP)
        supportActionBar?.setHomeAsUpIndicator(upArrow)

        val imgView = binding.saveQuestionView
        imgView.setOnClickListener{
            if (imgView.tag == "save_unfilled"){
                imgView.setImageResource(R.drawable.save_filled)
                imgView.tag = "save_filled"
            }else{
                imgView.setImageResource(R.drawable.save_unfilled)
                imgView.tag = "save_unfilled"
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            android.R.id.home -> {
                finish()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

}