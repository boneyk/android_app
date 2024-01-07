package com.example.travel_agency.ViewModel

import android.app.Application
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.travel_agency.databinding.FragmentProfileBinding
import com.example.travel_agency.models.ConfirmResponse
import com.example.travel_agency.models.PersInfo
import network_api.APIBuilder

class ProfileViewModel(val context: Application) : AndroidViewModel(context) {
    private val apiService = APIBuilder()
    var Infolist: MutableLiveData<PersInfo> = MutableLiveData()

    private lateinit var sharedPref: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    fun tryUpdateProf(binding: FragmentProfileBinding) {
        val name = binding.profName.text.toString()
        Log.d("MyLog", "имя = ${name}")
        val phone = binding.profPhone.text.toString()
        Log.d("MyLog", "телефон = ${phone}")
        sharedPref = context.getSharedPreferences("myPref", MODE_PRIVATE)
        editor = sharedPref.edit()
        updateUserProf(sharedPref.getString("token", null)!!,name,phone)
    }
    fun getUserInfo(id : String){
        apiService.getUserInfo(id ,object : APIBuilder.InfoCallback {
            override fun onSuccess(response: PersInfo) {
                Log.d("MyLog", "info!! = ${response.email}")
                Infolist.value = response
            }

            override fun onError() {
                Log.d("MyLog", "onError() ")
                Toast.makeText(context, "Возникла ошибка с получением туров", Toast.LENGTH_LONG).show()
            }

            override fun onFailure(error: Throwable) {
                Log.d("MyLog", "info!! = onFailure()")
                Toast.makeText(context, "Ошибка подключения к серверу", Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun updateUserProf(id : String, name : String, phone : String) {
        apiService.putUserInfo(id,name,phone, object : APIBuilder.ProfCallback {
            override fun onSuccess() {
                Toast.makeText(context, "Информация успешно обновлена", Toast.LENGTH_LONG).show()
            }

            override fun onError() {
                Toast.makeText(context, "Ошибка при обновлении пользователя", Toast.LENGTH_LONG).show()
            }

            override fun onFailure(error: Throwable) {
                Toast.makeText(context, "Ошибка подключения", Toast.LENGTH_LONG).show()
            }
        })
    }
}