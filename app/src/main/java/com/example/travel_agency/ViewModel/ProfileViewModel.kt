package com.example.travel_agency.ViewModel

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import com.example.travel_agency.Storage
import com.example.travel_agency.databinding.ActivityRegBinding
import com.example.travel_agency.databinding.FragmentProfileBinding
import com.example.travel_agency.models.PersInfo
import com.example.travel_agency.models.ProfRequest
import com.example.travel_agency.models.Tours
import network_api.InitAPI

class ProfileViewModel(val context: Application) : AndroidViewModel(context) {
    private val apiService = InitAPI()
    private val storage = Storage(context)

    fun tryUpdateProf(binding: FragmentProfileBinding) {
        val name = binding.profName.text.toString()
        val phone = binding.profPhone.text.toString()
        updateUserProf(storage.getUserId(),name,phone)
        getUserInfo(storage.getUserId())
    }
    fun getUserInfo(id : Int){
        apiService.getUserInfo(id ,object : InitAPI.InfoCallback {
            override fun onSuccess(response: PersInfo) {
                Log.d("MyLog", "info!! = ${response.email}")
                storage.savePersInfo(response)
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

    private fun updateUserProf(id : Int, name : String, phone : String) {
        apiService.putUserInfo(id,name,phone, object : InitAPI.ProfCallback {
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