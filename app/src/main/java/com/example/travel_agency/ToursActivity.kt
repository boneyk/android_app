package com.example.travel_agency

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ToursActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tours)

        val toursList: RecyclerView = findViewById(R.id.toursList)
        val tours = arrayListOf<Tour>()

        tours.add(Tour(1,"Египет", "Каир", "19-11-2023", "26-11-2023",3,3500.0,"egypt"))
        tours.add(Tour(2,"Нидерланды", "Амстердам", "21-11-2023", "24-11-2023",2,5500.0,"amsterdam"))
        tours.add(Tour(3,"Южная Корея", "Сеул", "30-11-2023", "06-12-2023",1,2500.0,"southkorea"))

        toursList.layoutManager = LinearLayoutManager(this)
        toursList.adapter = TourAdapter(tours,this)
    }
}