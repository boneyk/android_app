package com.example.travel_agency.ViewModel

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.travel_agency.databinding.FragmentToursBinding
import com.example.travel_agency.models.TourFav
import com.example.travel_agency.models.Tours
import network_api.InitAPI

class FaveViewModel(val context: Application) : AndroidViewModel(context)  {
    private val apiService = InitAPI()
    val Favetours: MutableLiveData<List<TourFav>> = MutableLiveData()

    fun findFavetour(user_id: Int) {
        apiService.findFavTour(user_id, object : InitAPI.TourFavCallback{
            override fun onSuccess(response: List<TourFav>) {
                if (response.isNotEmpty()){
//                    Log.d("MyLog", "Запрос перешел в ToursVIewModel в функцию getTours()")
                    Favetours.value = response
                }else{
                    Toast.makeText(context, "Сегодня в нашем агентстве нет туров :(", Toast.LENGTH_LONG).show()
                }
            }

            override fun onError() {
                Toast.makeText(context, "Возникла ошибка с получением туров", Toast.LENGTH_LONG).show()
            }

            override fun onFailure(error: Throwable) {
                Toast.makeText(context, "Ошибка подключения к серверу", Toast.LENGTH_LONG).show()
            }
        })
    }
}