package com.example.travel_agency.models

class TourResponse(
    val persons: List<Person>,
    val tour: Tour,
    val user_token: String
) {
}