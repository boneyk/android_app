package com.example.travel_agency.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.travel_agency.ProfileFragment
import com.example.travel_agency.fragments.BasketFragment
import com.example.travel_agency.fragments.FaveFragment
import com.example.travel_agency.R
import com.example.travel_agency.fragments.ToursFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class AgencyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agency)

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.navigation)
        // handle navigation selection
        bottomNavigationView.setOnItemSelectedListener { item ->
            lateinit var fragment: Fragment
            when (item.itemId) {
                R.id.catalog -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame_place, ToursFragment())
                        .commit()
                }
                R.id.basket -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame_place, BasketFragment())
                        .commit()
                }
                R.id.favorite -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame_place, FaveFragment())
                        .commit()
                }
                R.id.profile -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame_place, ProfileFragment())
                        .commit()
                }
            }
            true
        }
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_place, ToursFragment())
            .commit()


    }
}