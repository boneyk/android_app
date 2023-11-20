package com.example.travel_agency

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RegActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_reg)

        val userName: EditText = findViewById(R.id.user_name)
        val userLogin: EditText = findViewById(R.id.user_login)
        val userEmail: EditText = findViewById(R.id.user_email)
        val userPassword: EditText = findViewById(R.id.user_password)
        val userPasswordCopy: EditText = findViewById(R.id.user_password_copy)
        val buttonReg: Button = findViewById(R.id.button_reg)
        val linkToAuth: TextView = findViewById(R.id.link_to_auth)

        linkToAuth.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        buttonReg.setOnClickListener {
            val name = userName.text.toString().trim()
            val login = userLogin.text.toString().trim()
            val email = userEmail.text.toString().trim()
            val password = userPassword.text.toString().trim()
            val passwordCopy = userPasswordCopy.text.toString().trim()

            if (name == "" || login == "" || password == "" || email == "" || passwordCopy == "") {
                Toast.makeText(this, "Не все поля заполнены", Toast.LENGTH_LONG).show()
            }else if(password != passwordCopy){
                Toast.makeText(this, "Пароль введен неверно", Toast.LENGTH_LONG).show()
            }else{
                val user = User(name,login,password)

                userName.text.clear()
                userLogin.text.clear()
                userEmail.text.clear()
                userPassword.text.clear()
                userPasswordCopy.text.clear()

                Toast.makeText(this, "Пользователь $login успешно прошел регистрацию", Toast.LENGTH_LONG).show()
            }
        }
    }
}