package com.example.travel_agency.ViewModel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.travel_agency.models.HistElement
import com.example.travel_agency.models.TourFav
import network_api.APIBuilder

class BasketViewModel(val context: Application) : AndroidViewModel(context)   {
    private val apiService = APIBuilder()
    val Histtours: MutableLiveData<List<HistElement>> = MutableLiveData()

    fun findHistTour(user_id: String) {
        apiService.findHistTour(user_id, object : APIBuilder.HistTourCallback{
            override fun onSuccess(response: List<HistElement>) {
                if (response.isNotEmpty()){
//                    Log.d("MyLog", "Запрос перешел в ToursVIewModel в функцию getTours()")
                    Histtours.value = response
                }else{
                    Toast.makeText(context, "Сегодня в нашем агентстве нет туров :(", Toast.LENGTH_LONG).show()
                }
            }

            override fun onError() {
                Toast.makeText(context, "В корзине еще нет туров", Toast.LENGTH_LONG).show()
            }

            override fun onFailure(error: Throwable) {
                Toast.makeText(context, "Ошибка подключения к серверу", Toast.LENGTH_LONG).show()
            }
        })
    }
}