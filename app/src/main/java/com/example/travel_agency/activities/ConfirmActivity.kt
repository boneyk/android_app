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
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.travel_agency.R
import com.example.travel_agency.ViewModel.BasketViewModel
import com.example.travel_agency.ViewModel.ConfViewModel
import com.example.travel_agency.ViewModel.FaveViewModel
import com.example.travel_agency.databinding.ActivityConfirmBinding
import com.example.travel_agency.models.ConfRequest

class ConfirmActivity : AppCompatActivity() {

    private lateinit var binding: ActivityConfirmBinding
    private lateinit var viewModel: ConfViewModel
    private lateinit var basketviewModel: BasketViewModel
    private lateinit var basketViewModel: BasketViewModel

    private lateinit var sharedPref: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_confirm)
        basketViewModel = ViewModelProvider(this)[BasketViewModel::class.java]
        sharedPref = getSharedPreferences("myPref", AppCompatActivity.MODE_PRIVATE)
        editor = sharedPref.edit()
//        basketViewModel.updateHist(sharedPref.getInt("tour_id", 0),sharedPref.getString("token", null)!!)
        viewModel = ViewModelProvider(this).get(ConfViewModel::class.java)
        val info = Memory(this).getConf()
        viewModel.orderTour(info.date_id,info.tour_id,info.token,info.person_list)

        viewModel.Conflist.observe(this, Observer { tours ->

            val tourists: List<String> = tours.person_list.map { it.fullname }
            val listView: ListView = findViewById(R.id.personslist)
            val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, tourists)
            listView.adapter = adapter
            val editConfCountry = findViewById<View>(R.id.conf_country) as TextView
            editConfCountry.isEnabled = false
            editConfCountry.text = tours.tour.country
            val editConfCity = findViewById<View>(R.id.conf_city) as TextView
            editConfCity.isEnabled = false
            editConfCity.text = tours.tour.city
            val editConfDateS = findViewById<View>(R.id.conf_dateS) as TextView
            editConfDateS.isEnabled = false
            editConfDateS.text = tours.date.dateStart
            val editDateE = findViewById<View>(R.id.conf_dateE) as TextView
            editDateE.isEnabled = false
            editDateE.text = tours.date.dateEnd
            val editConfPrice = findViewById<View>(R.id.conf_price) as TextView
            editConfPrice.isEnabled = false
            editConfPrice.text = (tours.person_list.size * tours.tour.price_per_one).toString()
            val editConfDesc = findViewById<View>(R.id.conf_description) as TextView
            editConfDesc.isEnabled = false
            editConfDesc.text = tours.tour.description
        })

        val linkToOrder: TextView = findViewById(R.id.button_conf)
        linkToOrder.setOnClickListener {
            viewModel.updateHist(info.date_id,info.tour_id,info.token,info.person_list)
        }

    }
}