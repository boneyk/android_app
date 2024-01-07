package com.example.travel_agency.ViewModel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.travel_agency.models.TourFav
import network_api.APIBuilder

class FaveViewModel(val context: Application) : AndroidViewModel(context)  {
    private val apiService = APIBuilder()
    val Favetours: MutableLiveData<List<TourFav>> = MutableLiveData()


    fun findFavetour(user_id: String) {
        apiService.findFavTour(user_id, object : APIBuilder.TourFavCallback{
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

    fun updateFave(tour_id: Int, user_id: String) {
        apiService.updateFave(tour_id, user_id, object : APIBuilder.UpdateFaveCallback {
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

    fun deleteFave(tour_id: Int, user_id: String) {
        apiService.deleteFave(tour_id, user_id, object : APIBuilder.UpdateFaveCallback {
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