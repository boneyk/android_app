package com.example.travel_agency.ViewModel

import Memory
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.travel_agency.models.ConfirmResponse
import network_api.APIBuilder

class SeeConfViewModel(val context: Application) : AndroidViewModel(context) {
    private val apiService = APIBuilder()
    private val storage = Memory(context)
    var Conflist: MutableLiveData<ConfirmResponse> = MutableLiveData()
}