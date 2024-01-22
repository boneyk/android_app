package com.example.travel_agency.models

class HistElement(
    val id: Int,
    val bookingEntity: BookingEntity,
    val participants: List<Person>,
    val people_amount: Int,
    val status: String
) {
}