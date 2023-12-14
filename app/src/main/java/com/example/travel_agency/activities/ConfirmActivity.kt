package com.example.travel_agency.activities

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.travel_agency.R

class ConfirmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_confirm)

        val editConfName = findViewById<View>(R.id.conf_name) as TextView
        editConfName.isEnabled = false
        val editConfLogin = findViewById<View>(R.id.conf_login) as TextView
        editConfLogin.isEnabled = false
        val editConfEmail = findViewById<View>(R.id.conf_email) as TextView
        editConfEmail.isEnabled = false
        val editConfPhone = findViewById<View>(R.id.conf_phone) as TextView
        editConfPhone.isEnabled = false
        val editConfSex = findViewById<View>(R.id.conf_sex) as TextView
        editConfSex.isEnabled = false
        val editConfDateBirth = findViewById<View>(R.id.conf_datebirth) as TextView
        editConfDateBirth.isEnabled = false
        val editConfCountry = findViewById<View>(R.id.conf_country) as TextView
        editConfCountry.isEnabled = false
        val editConfCity = findViewById<View>(R.id.conf_city) as TextView
        editConfCity.isEnabled = false
        val editConfDateS = findViewById<View>(R.id.conf_dateS) as TextView
        editConfDateS.isEnabled = false
        val editDateE = findViewById<View>(R.id.conf_dateE) as TextView
        editDateE.isEnabled = false
        val editConfPrice = findViewById<View>(R.id.conf_price) as TextView
        editConfPrice.isEnabled = false
        val editConfDesc = findViewById<View>(R.id.conf_description) as TextView
        editConfDesc.isEnabled = false
    }
}