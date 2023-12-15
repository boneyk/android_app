package com.example.travel_agency.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.travel_agency.R
import com.example.travel_agency.ViewModel.LoginViewModel
import com.example.travel_agency.ViewModel.RegViewModel
import com.example.travel_agency.databinding.ActivityRegBinding
import com.example.travel_agency.models.User

class RegActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegBinding
    private lateinit var viewModel: RegViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityRegBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[RegViewModel::class.java]

        val userLogin: EditText = findViewById(R.id.user_login)
        val userEmail: EditText = findViewById(R.id.user_email)
        val userPassword: EditText = findViewById(R.id.user_password)
        val userPasswordCopy: EditText = findViewById(R.id.user_password_copy)
        val buttonReg: Button = findViewById(R.id.button_reg)
        val linkToAuth: TextView = findViewById(R.id.link_to_auth)

        linkToAuth.setOnClickListener{
            val intent = Intent(this, SignActivity::class.java)
            startActivity(intent)
        }

        buttonReg.setOnClickListener {
            viewModel.tryReg(binding)

            viewModel.startAgencyActivityEvent.observe(this) {
                Toast.makeText(this, "Пользователь успешно прошел регистрацию", Toast.LENGTH_LONG).show()
                userLogin.text.clear()
                userPassword.text.clear()
                userEmail.text.clear()
                userPasswordCopy.text.clear()
                startActivity(Intent(this, AgencyActivity::class.java))
                finish()
            }
            }
        }
    }