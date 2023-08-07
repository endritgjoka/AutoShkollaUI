package com.example.autoshkollaui.Literature

import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import com.example.autoshkollaui.API.APIResponse
import com.example.autoshkollaui.API.ServiceGenerator
import com.example.autoshkollaui.API.generated_classes.Photo
import com.example.autoshkollaui.LiteratureViewActivity
import com.example.autoshkollaui.R
import com.example.autoshkollaui.databinding.ActivityLitBinding
import com.example.autoshkollaui.databinding.ActivityMainViewpagerBinding
import com.example.autoshkollaui.databinding.LiteratureViewPagerBinding
import com.example.autoshkollaui.presentation.CustomAdapter
import com.example.autoshkollaui.presentation.LiteratureModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LitActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLitBinding
    private lateinit var literatureViewPagerBinding: LiteratureViewPagerBinding
    private lateinit var literatureViewPagerAdapter: LiteratureViewPagerAdapter
    public var list = ArrayList<Photo>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLitBinding.inflate(layoutInflater)
        literatureViewPagerBinding =
            DataBindingUtil.setContentView(this, R.layout.literature_view_pager)
        setContentView(binding.root)
//        literatureViewPagerBinding.backImg.setOnClickListener{
//            finish()
//        }

        val toolbar = binding.literatureViewToolbar1


        val sharedData = intent.getStringExtra("title1")
        //  val toolbar = literatureViewPagerBinding.literatureViewToolbars
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setTitle(sharedData)

        //Change color of back button
        val upArrow = resources.getDrawable(
            androidx.constraintlayout.widget.R.drawable.abc_ic_ab_back_material,
            theme
        )
        upArrow.setColorFilter(
            resources.getColor(android.R.color.holo_orange_dark),
            PorterDuff.Mode.SRC_ATOP
        )
        supportActionBar?.setHomeAsUpIndicator(upArrow)

        val getPosition = intent.getIntExtra("position", 0)

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
                        literatureViewPagerAdapter = LiteratureViewPagerAdapter()
                        literatureViewPagerAdapter.setList(list)
                        binding.viewPager1.adapter = literatureViewPagerAdapter
                        binding.viewPager1.currentItem = getPosition
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
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    fun onBackClick(view: View) {
        val current = binding.viewPager1.currentItem
        if (current > 0) {
            binding.viewPager1.currentItem = current - 1

        }
    }

    fun onNextClick(view: View) {
        val current = binding.viewPager1.currentItem
        val numberOfElements = binding.viewPager1.adapter?.count ?: 0
        if (current < numberOfElements - 1) {
            binding.viewPager1.currentItem = current + 1

        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    fun finish(view: View) {
        finish()
    }

}