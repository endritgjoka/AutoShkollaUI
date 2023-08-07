package com.example.autoshkollaui

import ViewPagerAdapter1
import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.autoshkollaui.API.APIResponse
import com.example.autoshkollaui.API.ServiceGenerator
import com.example.autoshkollaui.API.generated_classes.Photo
import com.example.autoshkollaui.databinding.ActivityMainViewpagerBinding
import com.example.autoshkollaui.databinding.QuestionViewPagerBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ExamsFromAPIActivity : AppCompatActivity(){

    private lateinit var binding: ActivityMainViewpagerBinding
    private lateinit var itemViewPagerBinding : QuestionViewPagerBinding
    private lateinit var dataList: List<Photo>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainViewpagerBinding.inflate(layoutInflater)
        itemViewPagerBinding = DataBindingUtil.setContentView(this, R.layout.question_view_pager)
        setContentView(binding.root)
      //  customAlertDialogBinding = DataBindingUtil.setContentView(this, R.layout.custom_alert_dialog)

        //var list = ArrayList<ExamViewPagerModel>()
        val question = changeColor("A ju lejohet tejkalimi i kolones se mjeteve (4pike)?")

  //      for(i in 1..8) {

//            var obj1 = ExamViewPagerModel(
//                "Pyetja "+i+"/30",
//                R.drawable.profile,
//                question,
//                "Po, nese nuk pengohen mjetet prapa.",
//                "Po, sepse nuk ka mjete nga kahu i kundert dhe me shenja nuk eshte i ndaluar",
//                "Jo, ne asnje rast"
//            )

           // list.add(obj1)

//        }
//        var adapter = ExamViewPagerAdapter(list)
//        binding.viewPager.adapter = adapter

//        binding.viewPager.apply {
//            adapter = ExamViewPagerAdapter(list)
//        }

        val imgView = itemViewPagerBinding.saveIcon
        imgView.setOnClickListener{
            if (imgView.tag == "save_unfilled"){
                Log.i("MYTAG","HAHAHAHAHA")
                imgView.setImageResource(R.drawable.save_filled)
                imgView.tag = "save_filled"
            }else{
                Log.i("MYTAG","HAHAHAHAHA")
                imgView.setImageResource(R.drawable.save_unfilled)
                imgView.tag = "save_unfilled"
            }
        }

        val API_KEY = "Pyesk7uPdniTiCENNWVLq6HnR0ESr3tXcZCP1Vk7MdinmMosp3w56GbW"
        val query = "people"
        val per_page = 30

        val call: Call<APIResponse> = ServiceGenerator.apiService.getData(query, per_page,API_KEY)
        call.enqueue(object : Callback<APIResponse> {
            override fun onResponse(call: Call<APIResponse>, response: Response<APIResponse>) {
                if (response.isSuccessful) {
                     dataList = response.body()?.photos!!
                    for (i in 0..dataList.size -1){
                        dataList[i].alt = changeColor(dataList[i].alt)
                    }
                    if (!dataList.isNullOrEmpty()){
                        val myAdapter = ViewPagerAdapter1()
                        (dataList as MutableList<Photo>).shuffle()
                        myAdapter.setList(dataList as ArrayList<Photo>)
                        binding.viewPager.adapter = myAdapter
                    }else{
                        //Toast.makeText(requireContext(),"No Data",Toast.LENGTH_LONG).show()
                    }

                } else {
                  //  Toast.makeText(requireContext(),"Could not connect",Toast.LENGTH_LONG).show()

                }
            }

            override fun onFailure(call: Call<APIResponse>, t: Throwable) {

            }
        })

    }

    private fun changeColor( text:String): String {
        val spannable = SpannableString(text)
        val fColor = ForegroundColorSpan(Color.YELLOW)
        spannable.setSpan(fColor, text.length-8, text.length-2, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)

        return spannable.toString()
    }

     fun onBackClick(view: View) {
        val current = binding.viewPager.currentItem
        if(current > 0){
            binding.viewPager.currentItem = current - 1

        }
    }

     fun onNextClick(view: View) {
        val current = binding.viewPager.currentItem
        val numberOfElements = binding.viewPager.adapter?.count ?:0
        if(current < numberOfElements - 1){
           binding.viewPager.currentItem = current + 1

        }
    }

     fun continueOrClose(view: View){
        val customDialog = CutomDialog()
         customDialog.isCancelable = false
        customDialog.show(supportFragmentManager, "CustomDialog")

    }

//    fun saveQuestion(view:View){
//
//    }                                     `


}