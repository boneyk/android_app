package com.example.travel_agency.models

class TourFav(
    val id:Int,
    val country: String,
    val city: String,
    val tour_type:String,
    val price_per_one:Int,
    val images:List<Tour_Image>
) {
}