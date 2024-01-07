package com.example.travel_agency.ViewModel

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.travel_agency.models.Tour
import network_api.APIBuilder

class TourWithIdViewModel(val context: Application) : AndroidViewModel(context) {
    val tourWithId: MutableLiveData<Tour> = MutableLiveData()
    private val apiService = APIBuilder()
    private val sharedPref = context.getSharedPreferences("myPref", AppCompatActivity.MODE_PRIVATE)
    private val editor = sharedPref.edit()

    fun findTourWithId(id: Int) {
        apiService.findTourWithId(id, object : APIBuilder.TourCallback {
            override fun onSuccess(response: Tour) {
                Log.d("MyLog", "перешел в tourwithidviewmodel и получил успешный ответ, далее переписывает его в livedata")
                tourWithId.value = response
                editor.putInt("tour_id", response.id).apply()
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