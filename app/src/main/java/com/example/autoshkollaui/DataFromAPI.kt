package com.example.autoshkollaui

import com.example.autoshkollaui.API.generated_classes.Photo

data class DataFromAPI(
    val next_page: String,
    val page: Int,
    val per_page: Int,
    val photos: List<Photo>,
    val total_results: Int
)