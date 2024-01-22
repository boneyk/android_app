package com.example.travel_agency.activities

import Memory
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.travel_agency.R
import com.example.travel_agency.ViewModel.BasketViewModel
import com.example.travel_agency.ViewModel.ConfViewModel
import com.example.travel_agency.databinding.ActivityConfirmBinding
import com.example.travel_agency.models.Person

class SeeConfActivity : AppCompatActivity() {
    private lateinit var viewModel: ConfViewModel

    private lateinit var sharedPref: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_see_conf)
        viewModel = ViewModelProvider(this).get(ConfViewModel::class.java)
        sharedPref = getSharedPreferences("myPref", AppCompatActivity.MODE_PRIVATE)
        editor = sharedPref.edit()
        val tourId = intent.getIntExtra("tour_id", 0)
        val dateId = intent.getIntExtra("date_id", 0)
        val persons = Memory(this).getPers()
        val userId = sharedPref.getString("token", null)!!

        viewModel.orderTour(dateId,tourId,userId,persons)

        viewModel.Conflist.observe(this, Observer { tours ->

            val editStatus = findViewById<View>(R.id.status_text) as TextView
            val status =  Memory(this).getStatus()
            editStatus.text = "Статус заказа: " + status
            val tourists: List<String> = tours.person_list.map { it.fullname }
            val listView: ListView = findViewById(R.id.perslist)
            val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, tourists)
            listView.adapter = adapter
            val editConfCountry = findViewById<View>(R.id.seeconf_country) as TextView
            editConfCountry.isEnabled = false
            editConfCountry.text = tours.tour.country
            val editConfCity = findViewById<View>(R.id.seeconf_city) as TextView
            editConfCity.isEnabled = false
            editConfCity.text = tours.tour.city
            val editConfDateS = findViewById<View>(R.id.seeconf_dateS) as TextView
            editConfDateS.isEnabled = false
            editConfDateS.text = tours.date.dateStart
            val editDateE = findViewById<View>(R.id.seeconf_dateE) as TextView
            editDateE.isEnabled = false
            editDateE.text = tours.date.dateEnd
            val editConfPrice = findViewById<View>(R.id.seeconf_price) as TextView
            editConfPrice.isEnabled = false
            val pricePerOne = (tours.person_list.size * tours.tour.price_per_one)
            val formattedPrice = String.format("%,d", pricePerOne).replace(",", " ")
            editConfPrice.text = "$formattedPrice руб."
            val editConfDesc = findViewById<View>(R.id.seeconf_description) as TextView
            editConfDesc.isEnabled = false
            editConfDesc.text = tours.tour.description
        })

    }
    }
