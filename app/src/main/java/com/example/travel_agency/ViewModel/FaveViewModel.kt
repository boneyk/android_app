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
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
                Toast.makeText(context, "В избранном еще нет туров", Toast.LENGTH_LONG).show()
            }

            override fun onFailure(error: Throwable) {
                Toast.makeText(context, "Ошибка подключения к серверу", Toast.LENGTH_LONG).show()
            }
        })
    }

    fun updateFave(tour_id: Int, user_id: Int) {
        apiService.updateFave(tour_id, user_id, object : InitAPI.UpdateFaveCallback {
            override fun onSuccess() {
                Toast.makeText(context, "Тур добавлен в избранное", Toast.LENGTH_LONG).show()
            }

            override fun onError() {
                Toast.makeText(context, "Возникла ошибка с добавлением тура", Toast.LENGTH_LONG).show()
            }

            override fun onFailure(error: Throwable) {
                Toast.makeText(context, "Ошибка подключения к серверу", Toast.LENGTH_LONG).show()
            }
        })
    }

    fun deleteFave(tour_id: Int, user_id: Int) {
        apiService.deleteFave(tour_id, user_id, object : InitAPI.UpdateFaveCallback {
            override fun onSuccess() {
                Toast.makeText(context, "Тур удален из избранного", Toast.LENGTH_LONG).show()
            }

            override fun onError() {
                Toast.makeText(context, "Такого тура нет в списке избранного", Toast.LENGTH_LONG).show()
            }

            override fun onFailure(error: Throwable) {
                Toast.makeText(context, "Ошибка подключения к серверу", Toast.LENGTH_LONG).show()
            }
        })
    }

}