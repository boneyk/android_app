package com.example.travel_agency.ViewModel

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.travel_agency.R
import com.example.travel_agency.Memory
import com.example.travel_agency.databinding.ActivitySignBinding
import com.example.travel_agency.fragments.FaveFragment
import network_api.APIBuilder

class LoginViewModel(val context: Application) : AndroidViewModel(context){

    val startAgencyActivityEvent: MutableLiveData<StartAgencyActivityEvent> = MutableLiveData()
    val id_token: MutableLiveData<Int> = MutableLiveData()
    private val storage = Memory(context)
    private lateinit var faveFragment: FaveFragment
    var id : Int = 1
    class StartAgencyActivityEvent
    private val apiService = APIBuilder()
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
    fun loginUser(login: String, password: String) {
        apiService.loginUser(login, password, object : APIBuilder.LoginCallback {
            override fun onSuccess(response: Int) {
                Log.d("MyLog", "значение2 = $response")
                storage.saveUserId(response)
                id = response
                id_token.setValue(response)
                Log.d("MyLog", "значение2.2 = ${id_token.value}")
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