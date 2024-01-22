package com.example.travel_agency.models

class ConfRequest(
    val date_id : Int,
    val tour_id: Int,
    val token: String,
    val person_list: List<Person>
) {
}