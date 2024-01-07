package com.example.travel_agency.activities

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.travel_agency.R
import com.example.travel_agency.ViewModel.LoginViewModel
import com.example.travel_agency.databinding.ActivitySignBinding

class LoginActivity : AppCompatActivity(){
    private lateinit var binding: ActivitySignBinding
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]


        val userLogin: EditText = findViewById(R.id.user_login_auth)
        val userPassword: EditText = findViewById(R.id.user_password_auth)
        val buttonSign: Button = findViewById(R.id.button_dock)
        val linkToReg: TextView = findViewById(R.id.link_to_reg)

        linkToReg.setOnClickListener{
            val intent = Intent(this, RegActivity::class.java)
            startActivity(intent)
        }

        buttonSign.setOnClickListener{
            viewModel.tryEnter(binding)
            userLogin.text.clear()
            userPassword.text.clear()
        }
        viewModel.startAgencyActivityEvent.observe(this) {
            Toast.makeText(this, "Пользователь успешно авторизировался", Toast.LENGTH_LONG).show()
            startActivity(Intent(this, AgencyActivity::class.java))
            finish()
        }
    }
}