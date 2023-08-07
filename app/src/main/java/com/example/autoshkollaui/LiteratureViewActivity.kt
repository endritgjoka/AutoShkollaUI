package com.example.autoshkollaui

import android.content.Intent
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.autoshkollaui.API.APIResponse
import com.example.autoshkollaui.API.ServiceGenerator
import com.example.autoshkollaui.API.generated_classes.Photo
import com.example.autoshkollaui.Literature.LitActivity
import com.example.autoshkollaui.databinding.ActivityLiteratureViewBinding
import com.example.autoshkollaui.presentation.CustomAdapter
import com.example.autoshkollaui.presentation.LiteratureAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LiteratureViewActivity : AppCompatActivity(){

    private lateinit var binding : ActivityLiteratureViewBinding
    public var list = ArrayList<Photo>()
    private lateinit var sharedData :String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = DataBindingUtil.inflate(layoutInflater, R.layout.activity_literature_view, null, false)
        setContentView(binding.root)

        val toolbar = binding.literatureViewToolbar
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        sharedData = intent.getStringExtra("title").toString()
        toolbar.setTitle(sharedData)
//        binding.freeLiterature1.setOnClickListener{
//            val intent = Intent(this,  LitActivity::class.java)
//            intent.putExtra("title",sharedData)
//            startActivity(intent)
//        }

        //Change color of back button
        val upArrow = resources.getDrawable(androidx.constraintlayout.widget.R.drawable.abc_ic_ab_back_material, theme)
        upArrow.setColorFilter(resources.getColor(android.R.color.holo_orange_dark), PorterDuff.Mode.SRC_ATOP)
        supportActionBar?.setHomeAsUpIndicator(upArrow)

        val recyclerView: RecyclerView = binding.literatureViewRecycler
        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        val API_KEY = "Pyesk7uPdniTiCENNWVLq6HnR0ESr3tXcZCP1Vk7MdinmMosp3w56GbW"
        val query = "ocean"
        val per_page = 30

        val call: Call<APIResponse> = ServiceGenerator.apiService.getData(query, per_page,API_KEY)
        call.enqueue(object : Callback<APIResponse> {
            override fun onResponse(call: Call<APIResponse>, response: Response<APIResponse>) {
                if (response.isSuccessful) {
                    list = (response.body()?.photos as ArrayList<Photo>?)!!
                    if (!list.isNullOrEmpty()){
                      //  (list as MutableList<Photo>).shuffle()
                        val myAdapter = CustomAdapter(list, R.layout.custom)
                        myAdapter.setSelectListener( object : CustomAdapter.CustomListener {
                            override fun onItemClicked(position: Int) {
                                val intent = Intent(this@LiteratureViewActivity, LitActivity::class.java)
                                intent.putExtra("position", position)
                                intent.putExtra("title1",sharedData)
                                //intent.
                                startActivity(intent)

                            }
                        })
                        binding.literatureViewRecycler.adapter = myAdapter
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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            android.R.id.home ->{
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

//    private fun initRecyclerView(){
//        binding.literatureViewRecycler.apply {
//            val adapt = CustomAdapter(list, R.layout.custom)
//            adapt.setSelectListener( object : CustomAdapter.CustomListener {
//                override fun onItemClicked(position: Int) {
//                    val intent = Intent(context, LitActivity::class.java)
//                    intent.putExtra("position", position)
//                    intent.putExtra("title1",sharedData)
//                    //intent.
//                    startActivity(intent)
//
//                }
//            })
//            adapter = adapt
//        }
//
//    }

}