package com.example.travel_agency.ViewModel

import Memory
import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.travel_agency.models.ConfirmResponse
import com.example.travel_agency.models.Person
import network_api.APIBuilder

class ConfViewModel(val context: Application) : AndroidViewModel(context) {
    private val apiService = APIBuilder()
    private val storage = Memory(context)
    var Conflist: MutableLiveData<ConfirmResponse> = MutableLiveData()

    fun orderTour(date_id: Int,tour_id: Int,user_id: String,selectedPeople: List<Person>){
        apiService.orderTour(date_id,tour_id,user_id,selectedPeople, object : APIBuilder.ConfCallback {
            override fun onSuccess(response: ConfirmResponse) {
                Log.d("MyLog", "info!! = ${response.tour.country}")
                Conflist.value = response
            }

            override fun onError() {
                Log.d("MyLog", "onError() ")
                Toast.makeText(context, "Возникла ошибка с подтверждением заказа", Toast.LENGTH_LONG).show()
            }

            override fun onFailure(error: Throwable) {
                Log.d("MyLog", "info!! = onFailure()")
                Toast.makeText(context, "Ошибка подключения к серверу", Toast.LENGTH_LONG).show()
            }
        })
    }
    fun updateHist(date_id: Int,tour_id: Int,user_id: String,selectedPeople: List<Person>){
        apiService.updateHist(date_id,tour_id,user_id,selectedPeople, object : APIBuilder.ConfTourCallback {
            override fun onSuccess(response: Any) {
                Toast.makeText(context, "Спасибо за покупку! Тур добавлен в историю заказов!", Toast.LENGTH_LONG).show()
            }

            override fun onError() {
                Log.d("MyLog", "onError() ")
                Toast.makeText(context, "Возникла ошибка с подтверждением заказа", Toast.LENGTH_LONG).show()
            }

            override fun onFailure(error: Throwable) {
                Log.d("MyLog", "info!! = onFailure()")
                Toast.makeText(context, "Ошибка подключения к серверу", Toast.LENGTH_LONG).show()
            }
        })
    }
}