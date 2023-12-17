package com.example.travel_agency.activities

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.travel_agency.R
import com.example.travel_agency.ViewModel.TourWithIdViewModel
import com.example.travel_agency.ViewModel.ToursFragmentViewModel
import com.example.travel_agency.databinding.ActivityTourBinding

class TourActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTourBinding
    private lateinit var Viewmodel: TourWithIdViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTourBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        Viewmodel = ViewModelProvider(this)[TourWithIdViewModel::class.java]

        val cur_image : ImageView = binding.tourListImage
        val country: TextView = binding.tourCountry
        val city: TextView = binding.tourCity
        val capacity: TextView = binding.tourCapacity
        val sdate: TextView = binding.tourListDateS
        val fdate: TextView = binding.tourListDateF
        val desc: TextView = binding.tourListDesc
        val price: TextView = binding.tourPrice
//
//        val tour = Viewmodel.tourWithId.value
//        country.text = tour!!.country
//        city.text = tour!!.city
//        capacity.text = tour!!.capacity.toString()
//        sdate.text = "Начало: " + tour!!.date_start
//        fdate.text = "Конец: " + tour!!.date_end
//        desc.text = tour!!.description
//        price.text = tour!!.price_per_one.toString()

        val linkToConfirm: TextView = findViewById(R.id.button_buy)
        linkToConfirm.setOnClickListener{
//            val intent = Intent(this, ConfirmActivity::class.java)
//            startActivity(intent)
            Toast.makeText(this, "Давайте подтвердим заказ!", Toast.LENGTH_LONG).show()
            startActivity(Intent(this, ConfirmActivity::class.java))
            finish()
        }
//        viewModel.startConfirmActivityEvent.observe(this) {
//            Toast.makeText(this, "Давайте подтвердим заказ!", Toast.LENGTH_LONG).show()
//            startActivity(Intent(this, ConfirmActivity::class.java))
//            finish()
//        }
    }
}