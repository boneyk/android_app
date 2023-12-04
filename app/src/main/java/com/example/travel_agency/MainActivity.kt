package com.example.travel_agency

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val userLogin: EditText = findViewById(R.id.user_login_auth)
        val userPassword: EditText = findViewById(R.id.user_password_auth)
        val buttonSign: Button = findViewById(R.id.button_auth)
        val linkToReg: TextView = findViewById(R.id.link_to_reg)

        linkToReg.setOnClickListener{
            val intent = Intent(this, RegActivity::class.java)
            startActivity(intent)
        }

        buttonSign.setOnClickListener{
            val login = userLogin.text.toString().trim()
            val password = userPassword.text.toString().trim()

            if(login == "" || password == ""){
                Toast.makeText(this, "Не все поля заполнены", Toast.LENGTH_LONG).show()
            }else{
                val user = User(login,password)
                userLogin.text.clear()
                userPassword.text.clear()

                Toast.makeText(this, "Пользователь $login успешно прошел авторизацию", Toast.LENGTH_LONG).show()
                val intent = Intent(this,AgencyActivity::class.java)
                startActivity(intent)
            }
        }

    }
}