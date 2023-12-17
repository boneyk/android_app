package com.example.travel_agency.models


class Tours(
    val id:Int,
    val name: String,
    val price_per_one:Int,
    val tour_type: String,
    val images: List<Tour_Image>
    ) {
}