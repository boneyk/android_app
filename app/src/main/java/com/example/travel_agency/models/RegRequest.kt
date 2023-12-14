package com.example.travel_agency.models

class RegRequest(
    val login: String,
    val email: String,
    val password: String,
    val password_confirm: String
) {
}