package com.example.travel_agency.ViewModel

import android.app.Application
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.travel_agency.activities.ConfirmActivity
import com.example.travel_agency.adapters.TourListAdapter
import com.example.travel_agency.models.Tour
import com.example.travel_agency.models.Tours
import network_api.InitAPI

class TourWithIdViewModel(val context: Application) : AndroidViewModel(context) {
    val tourWithId: MutableLiveData<Tour> = MutableLiveData()
    private val apiService = InitAPI()

    fun findTourWithId(id: Int) {
        apiService.findTourWithId(id, object : InitAPI.TourCallback {
            override fun onSuccess(response: Tour) {
                Log.d("MyLog", "перешел в tourwithidviewmodel и получил успешный ответ, далее переписывает его в livedata")
                tourWithId.value = response
                Log.d("MyLog", "записал ответ в livedata")
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