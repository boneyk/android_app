package com.example.travel_agency.models

class Tour(
    val id: Int,
    val name:String,
    val country: String,
    val city: String,
    val tour_type: String,
    val capacity:Int,
    val price_per_one: Int,
    val description: String,
    val images:List<Tour_Image>,
    val date: List<Dates>
) {
}