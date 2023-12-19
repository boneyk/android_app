package com.example.travel_agency.activities

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.travel_agency.R
import com.example.travel_agency.Storage
import com.example.travel_agency.ViewModel.ConfViewModel
import com.example.travel_agency.ViewModel.TourWithIdViewModel
import com.example.travel_agency.databinding.ActivityConfirmBinding
import com.example.travel_agency.databinding.ActivityTourBinding

class ConfirmActivity : AppCompatActivity() {

    private lateinit var binding: ActivityConfirmBinding
    private lateinit var viewModel: ConfViewModel
    val storage = Storage(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_confirm)
        viewModel = ViewModelProvider(this).get(ConfViewModel::class.java)
        val tour_id = storage.getTourId()
        val user_id = storage.getUserId()
        viewModel.orderTour(user_id,tour_id)

        viewModel.Conflist.observe(this, Observer { tours ->
            val editConfName = findViewById<View>(R.id.conf_name) as TextView
            editConfName.isEnabled = false
            editConfName.text = tours.user.fullname
            val editConfLogin = findViewById<View>(R.id.conf_login) as TextView
            editConfLogin.isEnabled = false
            editConfLogin.text = tours.user.login
            val editConfEmail = findViewById<View>(R.id.conf_email) as TextView
            editConfEmail.isEnabled = false
            editConfEmail.text = tours.user.email
            val editConfPhone = findViewById<View>(R.id.conf_phone) as TextView
            editConfPhone.isEnabled = false
            editConfPhone.text = tours.user.phone_number
            val editConfCountry = findViewById<View>(R.id.conf_country) as TextView
            editConfCountry.isEnabled = false
            editConfCountry.text = tours.tour.country
            val editConfCity = findViewById<View>(R.id.conf_city) as TextView
            editConfCity.isEnabled = false
            editConfCity.text = tours.tour.city
            val editConfDateS = findViewById<View>(R.id.conf_dateS) as TextView
            editConfDateS.isEnabled = false
            editConfDateS.text = tours.tour.date_start
            val editDateE = findViewById<View>(R.id.conf_dateE) as TextView
            editDateE.isEnabled = false
            editDateE.text = tours.tour.date_end
            val editConfPrice = findViewById<View>(R.id.conf_price) as TextView
            editConfPrice.isEnabled = false
            editConfPrice.text = tours.tour.price_per_one.toString()
            val editConfDesc = findViewById<View>(R.id.conf_description) as TextView
            editConfDesc.isEnabled = false
            editConfDesc.text = tours.tour.description
        })


    }
}