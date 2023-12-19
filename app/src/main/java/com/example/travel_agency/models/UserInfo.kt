package com.example.travel_agency.models

class UserInfo(
    val id:Int,
    val email: String,
    val login: String,
    val password:String,
    val password_confirm:String,
    val fullname:String,
    val phone_number:String,
    val favorites: List<Tour>,
    val history: List<TourFav>
) {
}