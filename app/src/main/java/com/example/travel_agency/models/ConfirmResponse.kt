package com.example.travel_agency.models

class ConfirmResponse(
    val tour: Tour,
    val date: Dates,
    val token:String,
    val person_list: List<Person>
) {
}