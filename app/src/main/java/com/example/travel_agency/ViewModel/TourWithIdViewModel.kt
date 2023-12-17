package com.example.travel_agency.ViewModel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.travel_agency.R
import com.example.travel_agency.databinding.ActivitySignBinding
import com.example.travel_agency.databinding.ActivityTourBinding
import com.example.travel_agency.models.Tour
import network_api.InitAPI

class TourViewModel(val context: Application) : AndroidViewModel(context) {
    val startConfirmActivityEvent: MutableLiveData<StartConfirmActivityEvent> = MutableLiveData()
    class StartConfirmActivityEvent
    private val apiService = InitAPI()


}