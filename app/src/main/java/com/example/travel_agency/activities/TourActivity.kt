package com.example.travel_agency.activities

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.travel_agency.R

class TourActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tour)

        val title: TextView = findViewById(R.id.tour_title)
        val text: TextView = findViewById(R.id.tour_city)
        val sdate: TextView = findViewById(R.id.tour_list_dateS)
        val fdate: TextView = findViewById(R.id.tour_list_dateF)
        val desc: TextView = findViewById(R.id.tour_list_desc)
        val price: TextView = findViewById(R.id.tour_price)

        title.text = intent.getStringExtra("tourTitle" )
        text.text = intent.getStringExtra("tourCity")
        sdate.text = "Начало: " + intent.getStringExtra( "tourSDate")
        fdate.text = "Конец: " + intent.getStringExtra("tourEDate")
        desc.text = intent.getStringExtra("tourDesc")
        price.text = intent.getStringExtra("tourPrice")

    }
}