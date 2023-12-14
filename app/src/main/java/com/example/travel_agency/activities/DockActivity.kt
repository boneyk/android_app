package com.example.travel_agency.activities

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.travel_agency.R


class DockActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dock)

        val editPassButton = findViewById<View>(R.id.passport_edit_button) as Button
        val cancelPassButton = findViewById<View>(R.id.pass_cancelbutton) as Button
        val savePassButton = findViewById<View>(R.id.pass_okbutton) as Button

        cancelPassButton.setOnClickListener {
            val passCancel = findViewById<View>(R.id.pass_cancelbutton)
            passCancel.visibility = View.GONE
            val passSave = findViewById<View>(R.id.pass_okbutton)
            passSave.visibility = View.GONE
            val editPassName = findViewById<View>(R.id.info_passport_name) as EditText
            editPassName.isEnabled = false
            val editPassSex = findViewById<View>(R.id.info_passport_sex) as EditText
            editPassSex.isEnabled = false
            val editPassBirth = findViewById<View>(R.id.info_passport_birth) as EditText
            editPassBirth.isEnabled = false
            val editPassCitizenship = findViewById<View>(R.id.info_passport_citizenship) as EditText
            editPassCitizenship.isEnabled = false
            val editPassSeria = findViewById<View>(R.id.info_passport_seria) as EditText
            editPassSeria.isEnabled = false
            val editPassNumber = findViewById<View>(R.id.info_passport_number) as EditText
            editPassNumber.isEnabled = false
            val editPassDateReg = findViewById<View>(R.id.info_passport_datereg) as EditText
            editPassDateReg.isEnabled = false
            val editPassPeopleReg = findViewById<View>(R.id.info_passport_peoplereg) as EditText
            editPassPeopleReg.isEnabled = false
            val editPassPlace = findViewById<View>(R.id.info_passport_place) as EditText
            editPassPlace.isEnabled = false
        }
        savePassButton.setOnClickListener {
            val passCancel = findViewById<View>(R.id.pass_cancelbutton)
            passCancel.visibility = View.GONE
            val passSave = findViewById<View>(R.id.pass_okbutton)
            passSave.visibility = View.GONE
            val editPassName = findViewById<View>(R.id.info_passport_name) as EditText
            editPassName.isEnabled = false
            val editPassSex = findViewById<View>(R.id.info_passport_sex) as EditText
            editPassSex.isEnabled = false
            val editPassBirth = findViewById<View>(R.id.info_passport_birth) as EditText
            editPassBirth.isEnabled = false
            val editPassCitizenship = findViewById<View>(R.id.info_passport_citizenship) as EditText
            editPassCitizenship.isEnabled = false
            val editPassSeria = findViewById<View>(R.id.info_passport_seria) as EditText
            editPassSeria.isEnabled = false
            val editPassNumber = findViewById<View>(R.id.info_passport_number) as EditText
            editPassNumber.isEnabled = false
            val editPassDateReg = findViewById<View>(R.id.info_passport_datereg) as EditText
            editPassDateReg.isEnabled = false
            val editPassPeopleReg = findViewById<View>(R.id.info_passport_peoplereg) as EditText
            editPassPeopleReg.isEnabled = false
            val editPassPlace = findViewById<View>(R.id.info_passport_place) as EditText
            editPassPlace.isEnabled = false
        }
//        Кнопка - редактировать для паспорта
        editPassButton.setOnClickListener {
            //  паспорт
            val editPassName = findViewById<View>(R.id.info_passport_name) as EditText
            editPassName.isEnabled = true
            val editPassSex = findViewById<View>(R.id.info_passport_sex) as EditText
            editPassSex.isEnabled = true
            val editPassBirth = findViewById<View>(R.id.info_passport_birth) as EditText
            editPassBirth.isEnabled = true
            val editPassCitizenship = findViewById<View>(R.id.info_passport_citizenship) as EditText
            editPassCitizenship.isEnabled = true
            val editPassSeria = findViewById<View>(R.id.info_passport_seria) as EditText
            editPassSeria.isEnabled = true
            val editPassNumber = findViewById<View>(R.id.info_passport_number) as EditText
            editPassNumber.isEnabled = true
            val editPassDateReg = findViewById<View>(R.id.info_passport_datereg) as EditText
            editPassDateReg.isEnabled = true
            val editPassPeopleReg = findViewById<View>(R.id.info_passport_peoplereg) as EditText
            editPassPeopleReg.isEnabled = true
            val editPassPlace = findViewById<View>(R.id.info_passport_place) as EditText
            editPassPlace.isEnabled = true
            //        ОТМЕНА И СОХРАНИТЬ - паспорт
            val passCancel = findViewById<View>(R.id.pass_cancelbutton)
            passCancel.visibility = View.VISIBLE
            val passSave = findViewById<View>(R.id.pass_okbutton)
            passSave.visibility = View.VISIBLE
        }
//  паспорт
        //        ОТМЕНА И СОХРАНИТЬ - паспорт
        val passCancel = findViewById<View>(R.id.pass_cancelbutton)
        passCancel.visibility = View.GONE
        val passSave = findViewById<View>(R.id.pass_okbutton)
        passSave.visibility = View.GONE
        val editPassName = findViewById<View>(R.id.info_passport_name) as EditText
        editPassName.isEnabled = false
        val editPassSex = findViewById<View>(R.id.info_passport_sex) as EditText
        editPassSex.isEnabled = false
        val editPassBirth = findViewById<View>(R.id.info_passport_birth) as EditText
        editPassBirth.isEnabled = false
        val editPassCitizenship = findViewById<View>(R.id.info_passport_citizenship) as EditText
        editPassCitizenship.isEnabled = false
        val editPassSeria = findViewById<View>(R.id.info_passport_seria) as EditText
        editPassSeria.isEnabled = false
        val editPassNumber = findViewById<View>(R.id.info_passport_number) as EditText
        editPassNumber.isEnabled = false
        val editPassDateReg = findViewById<View>(R.id.info_passport_datereg) as EditText
        editPassDateReg.isEnabled = false
        val editPassPeopleReg = findViewById<View>(R.id.info_passport_peoplereg) as EditText
        editPassPeopleReg.isEnabled = false
        val editPassPlace = findViewById<View>(R.id.info_passport_place) as EditText
        editPassPlace.isEnabled = false
    }
}