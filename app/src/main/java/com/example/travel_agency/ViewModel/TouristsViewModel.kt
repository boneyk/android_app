package com.example.travel_agency.ViewModel

import android.app.Application
import android.content.SharedPreferences
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.travel_agency.models.ConfirmResponse
import com.example.travel_agency.models.DocksInfo
import com.example.travel_agency.models.LoginResponse
import com.example.travel_agency.models.Person
import network_api.APIBuilder

class TouristsViewModel(val context: Application) : AndroidViewModel(context) {
    private val apiService = APIBuilder()
    var peoplist: MutableLiveData<List<Person>> = MutableLiveData()

    private lateinit var sharedPref: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    fun getDocks(user_id: String){
        apiService.getDocks(user_id, object : APIBuilder.DockCallback {
            override fun onSuccess(response: List<Person>) {
                peoplist.value = response
            }

            override fun onError() {
                Log.d("MyLog", "onError() ")
//                Toast.makeText(context, "Возникла ошибка с подтверждением заказа", Toast.LENGTH_LONG).show()
            }

            override fun onFailure(error: Throwable) {
                Log.d("MyLog", "info!! = onFailure()")
                Toast.makeText(context, "Ошибка подключения к серверу", Toast.LENGTH_LONG).show()
            }
        })
    }

    fun putPeop(user_id: String){
        apiService.putPeop(user_id, object : APIBuilder.LoginCallback {
            override fun onSuccess(response: LoginResponse) {
                Toast.makeText(context, "Турист добавлен", Toast.LENGTH_LONG).show()
            }

            override fun onError() {
                Log.d("MyLog", "onError() ")
//                Toast.makeText(context, "Возникла ошибка с добавление туриста", Toast.LENGTH_LONG).show()
            }

            override fun onFailure(error: Throwable) {
                Log.d("MyLog", "info!! = onFailure()")
//                Toast.makeText(context, "Ошибка подключения к серверу", Toast.LENGTH_LONG).show()
            }
        })
    }
}