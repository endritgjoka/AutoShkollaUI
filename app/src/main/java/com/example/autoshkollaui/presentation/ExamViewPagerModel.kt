package com.example.autoshkollaui.presentation

import com.google.gson.annotations.SerializedName

data class ExamViewPagerModel(
    @SerializedName("next_page")
    val numberOfQuestion: String,
    @SerializedName("original")
    val image: String,
    @SerializedName("next_page")
    val question:String,
    @SerializedName("next_page")
    val option1:String,
    @SerializedName("next_page")
    val option2:String,
    @SerializedName("next_page")
    val option3:String)