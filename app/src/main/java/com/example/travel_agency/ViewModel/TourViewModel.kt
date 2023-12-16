package com.example.travel_agency.ViewModel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.travel_agency.models.Tour
import network_api.InitAPI

class TourViewModel(val context: Application) : AndroidViewModel(context) {
    val startConfirmActivityEvent: MutableLiveData<StartConfirmActivityEvent> = MutableLiveData()
    class StartConfirmActivityEvent
    private val apiService = InitAPI()

    private fun findTourWithId(id: Int) {
        apiService.findTourWithId(id, object : InitAPI.TourCallback {
            override fun onSuccess(response: Tour) {

                startConfirmActivityEvent.value = StartConfirmActivityEvent()
            }

            override fun onError() {
                Toast.makeText(context, "Пользователь не найден", Toast.LENGTH_LONG).show()
            }

            override fun onFailure(error: Throwable) {
                Toast.makeText(context, "Ошибка подключения", Toast.LENGTH_LONG).show()
            }
        })
    }
}