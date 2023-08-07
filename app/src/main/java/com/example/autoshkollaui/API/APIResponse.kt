package com.example.autoshkollaui.API

import com.example.autoshkollaui.API.generated_classes.Photo


data class APIResponse(
    val photos: List<Photo>,
    val total_results: Int
)