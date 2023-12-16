package com.example.travel_agency.activities

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.travel_agency.R
import com.example.travel_agency.ViewModel.LoginViewModel
import com.example.travel_agency.ViewModel.TourViewModel
import com.example.travel_agency.databinding.ActivitySignBinding
import com.example.travel_agency.databinding.ActivityTourBinding

class TourActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTourBinding
    private lateinit var viewModel: TourViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTourBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[TourViewModel::class.java]

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

        val linkToConfirm: TextView = findViewById(R.id.button_buy)
        linkToConfirm.setOnClickListener{
            val intent = Intent(this, ConfirmActivity::class.java)
            startActivity(intent)
        }
        viewModel.startConfirmActivityEvent.observe(this) {
            Toast.makeText(this, "Давайте подтвердим заказ!", Toast.LENGTH_LONG).show()
            startActivity(Intent(this, ConfirmActivity::class.java))
            finish()
        }
    }
}