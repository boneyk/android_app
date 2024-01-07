package com.example.travel_agency.ViewModel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.travel_agency.R
import com.example.travel_agency.databinding.ActivityRegBinding
import com.example.travel_agency.models.LoginResponse
import network_api.APIBuilder

class RegViewModel(val context: Application) : AndroidViewModel(context){
    val startAgencyActivityEvent: MutableLiveData<StartAgencyActivityEvent> = MutableLiveData()
    class StartAgencyActivityEvent
    private val apiService = APIBuilder()

    fun tryReg(binding: ActivityRegBinding) {
        val login = binding.userLogin.text.toString().trim()
        val email = binding.userEmail.text.toString()
        val password = binding.userPassword.text.toString()
        val password_confirm = binding.userPasswordCopy.text.toString()


        if (login == "" || password == "" || email == "" || password_confirm == "") {
            if (login == "") binding.userLogin.error =
                context.getString(R.string.login_errer_message)
            if (password == "") binding.userPassword.error =
                context.getString(R.string.password_errer_message)
            if (email == "") binding.userEmail.error =
                context.getString(R.string.email_errer_message)
            if (password_confirm == "") binding.userPasswordCopy.error =
                context.getString(R.string.password_errer_message)
            Toast.makeText(
                context, "Не все поля заполнены", Toast.LENGTH_SHORT).show()
        } else {
            regUser(login,email,password,password_confirm)
        }
    }
    private fun regUser(login: String,email:String,password: String,password_confirm:String) {
        apiService.regUser(login,email,password,password_confirm, object : APIBuilder.RegCallback {
            override fun onSuccess(response: LoginResponse) {
                startAgencyActivityEvent.value = RegViewModel.StartAgencyActivityEvent()
            }

            override fun onError() {
                if(password != password_confirm)
                    Toast.makeText(context, "Пароль не совпадает", Toast.LENGTH_LONG).show()
                else
                    Toast.makeText(context, "Такой пользователь уже существует", Toast.LENGTH_LONG).show()
            }

            override fun onFailure(error: Throwable) {
                Toast.makeText(context, "Ошибка подключения", Toast.LENGTH_LONG).show()
            }
        })
    }
}