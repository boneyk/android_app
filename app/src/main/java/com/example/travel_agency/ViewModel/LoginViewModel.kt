package com.example.travel_agency.ViewModel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.travel_agency.R
import com.example.travel_agency.databinding.ActivitySignBinding
import network_api.InitAPI

class LoginViewModel(val context: Application) : AndroidViewModel(context){

    val startAgencyActivityEvent: MutableLiveData<StartAgencyActivityEvent> = MutableLiveData()
    class StartAgencyActivityEvent
    private val apiService = InitAPI()
    fun tryEnter(binding: ActivitySignBinding) {
        val login = binding.userLoginAuth.text.toString().trim()
        val password = binding.userPasswordAuth.text.toString()

        if (login == "" || password == "") {
            if (login == "") binding.userLoginAuth.error =
                context.getString(R.string.login_errer_message)
            if (password == "") binding.userPasswordAuth.error =
                context.getString(R.string.password_errer_message)
            Toast.makeText(
                context, "Не все поля заполнены", Toast.LENGTH_SHORT).show()
        } else {
            loginUser(login, password)
        }
    }

    private fun loginUser(login: String, password: String) {
        apiService.loginUser(login, password, object : InitAPI.LoginCallback {
            override fun onSuccess(response: Any) {
                startAgencyActivityEvent.value = StartAgencyActivityEvent()
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