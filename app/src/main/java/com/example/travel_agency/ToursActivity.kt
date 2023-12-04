package com.example.travel_agency

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class ToursActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tours)

        val fragmentManager: FragmentManager = supportFragmentManager

        // define your fragments here
        val toursFr: Fragment = ToursFragment()
        val basketFr: Fragment = BasketFragment()
        val profileFr: Fragment = ProfileFragment()

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


//        binding = ActivityToursBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        supportFragmentManager.beginTransaction()
//            .replace(R.id.catalog, ToursFragment())
//            .commit()
//
//        val bottomNavigationView: BottomNavigationView = findViewById(R.id.navigation)
//
//        bottomNavigationView.setOnItemSelectedListener { item ->
//            when (item.itemId) {
//                R.id.catalog ->{
//                    supportFragmentManager.beginTransaction()
//                        .replace(R.id.catalog, ToursFragment())
//                        .commit()
//                    true
//                }
//                R.id.basket->{
//                        supportFragmentManager.beginTransaction()
//                            .replace(R.id.basket, ToursFragment())
//                            .commit()
//                    true
//                }
//                R.id.profile -> {
//                    supportFragmentManager.beginTransaction()
//                        .replace(R.id.profile, ToursFragment())
//                        .commit()
//                    true
//                }
//                else -> true
//            }
//        }

    }
}