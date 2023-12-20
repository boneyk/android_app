package com.example.travel_agency.activities

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.travel_agency.R
import com.example.travel_agency.Memory
import com.example.travel_agency.ViewModel.BasketViewModel
import com.example.travel_agency.ViewModel.FaveViewModel
import com.example.travel_agency.ViewModel.TourWithIdViewModel
import com.example.travel_agency.databinding.ActivityTourBinding

class TourActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTourBinding
    private lateinit var viewModel: TourWithIdViewModel
    private lateinit var tourIdModel: TourWithIdViewModel
    private lateinit var faveViewModel: FaveViewModel
    private lateinit var basketViewModel: BasketViewModel
    val storage = Memory(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTourBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(TourWithIdViewModel::class.java)

        val curImage: ImageView = binding.tourListImage
        val country: TextView = binding.tourCountry
        val city: TextView = binding.tourCity
        val capacity: TextView = binding.tourCapacity
        val sDate: TextView = binding.tourListDateS
        val fDate: TextView = binding.tourListDateF
        val desc: TextView = binding.tourListDesc
        val price: TextView = binding.tourPrice

        val tourId = intent.getIntExtra("tour_id", 0)
        tourIdModel = ViewModelProvider(this).get(TourWithIdViewModel::class.java)
        tourIdModel.findTourWithId(tourId)
        tourIdModel.tourWithId.observe(this, Observer { tour ->
            country.text = tour?.country
            city.text = "Город: " + tour?.city
            capacity.text = "Количество человек: " + tour?.capacity.toString()
            sDate.text = "Начало: " + tour?.date_start
            fDate.text = "Конец: " + tour?.date_end
            desc.text = tour?.description
            price.text = tour?.price_per_one.toString() + " руб."
            // Установка изображения в соответствии с элементом массива tour.images
            val imageId = resources.getIdentifier(tour?.images?.get(0)?.filename, "drawable", packageName)
            curImage.setImageResource(imageId)
        })

        val linkToConfirm: TextView = findViewById(R.id.button_buy)
        val linkToFave: TextView = findViewById(R.id.button_toFave)
        val linkFromFave: TextView = findViewById(R.id.button_fromFave)
        linkToConfirm.setOnClickListener {
            storage.saveTourId(tourId)
            basketViewModel = ViewModelProvider(this)[BasketViewModel::class.java]
            basketViewModel.updateHist(storage.getTourId(),storage.getUserId())
            Toast.makeText(this, "Давайте подтвердим заказ!", Toast.LENGTH_LONG).show()
            startActivity(Intent(this, ConfirmActivity::class.java))
            finish()
        }
        linkToFave.setOnClickListener {
            val tour_id = storage.getTourId()
            val user_id = storage.getUserId()
            faveViewModel = ViewModelProvider(this)[FaveViewModel::class.java]
            faveViewModel.updateFave(tour_id,user_id)
        }
        linkFromFave.setOnClickListener {
            val tour_id = storage.getTourId()
            val user_id = storage.getUserId()
            faveViewModel = ViewModelProvider(this)[FaveViewModel::class.java]
            faveViewModel.deleteFave(tour_id,user_id)
            faveViewModel.findFavetour(user_id)
        }
    }
}
