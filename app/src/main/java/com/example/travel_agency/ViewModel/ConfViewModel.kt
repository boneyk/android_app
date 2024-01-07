package com.example.travel_agency.ViewModel

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.travel_agency.models.ConfirmResponse
import network_api.APIBuilder

class ConfViewModel(val context: Application) : AndroidViewModel(context) {
    private val apiService = APIBuilder()
    var Conflist: MutableLiveData<ConfirmResponse> = MutableLiveData()

    fun orderTour(id_user : String,id_tour : Int){
        apiService.orderTour(id_user, id_tour, object : APIBuilder.ConfCallback {
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
}