package com.example.travel_agency.activities

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.travel_agency.R
import com.example.travel_agency.ViewModel.DocksViewModel
import com.example.travel_agency.ViewModel.ProfileViewModel
import com.example.travel_agency.ViewModel.TouristsViewModel
import com.example.travel_agency.databinding.ActivityDockBinding
import com.example.travel_agency.databinding.FragmentProfileBinding


class DockActivity : AppCompatActivity() {
    private var user_id: String  = "1"
    private lateinit var viewModel: DocksViewModel
    private lateinit var touristviewModel: TouristsViewModel
    private lateinit var binding: ActivityDockBinding

    private lateinit var sharedPref: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor
    fun finallyGetIt(){
        user_id = sharedPref.getString("doc_token", null)!!
        viewModel.getDocksInfo(user_id)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dock)

        var name : String
        var phone : String

        var fullname : String
        var sex : String
        var dob: String
        var citizenship:String
        var serial: String
        var number: String
        var dog: String
        var wg: String
        var registration: String

        binding = ActivityDockBinding.inflate(layoutInflater)
        val cancelPassButton: View = findViewById(R.id.pass_cancelbutton)
        cancelPassButton.visibility = View.GONE
        val savePassButton: View = findViewById(R.id.pass_okbutton)
        savePassButton.visibility = View.GONE
        val editPassButton: View = findViewById(R.id.passport_edit_button)

        sharedPref = getSharedPreferences("myPref", AppCompatActivity.MODE_PRIVATE)
        editor = sharedPref.edit()

        viewModel = ViewModelProvider(this)[DocksViewModel::class.java]
        touristviewModel = ViewModelProvider(this).get(TouristsViewModel::class.java)

        user_id = sharedPref.getString("doc_token", null)!!
        val token = sharedPref.getString("token", null)!!
        viewModel.getDocksInfo(user_id)
        finallyGetIt()

        val editName =findViewById(R.id.info_name) as EditText
        val editPhone =findViewById(R.id.info_phone) as EditText

        val cancelInfoButton: View = findViewById(R.id.info2_cancelbutton)
        cancelInfoButton.visibility = View.GONE
        val saveInfoButton: View = findViewById(R.id.info2_okbutton)
        saveInfoButton.visibility = View.GONE
        val editInfoButton: View = findViewById(R.id.info2_edit_button)

        val editPassName =findViewById(R.id.info_passport_name) as EditText
        val editPassSex = findViewById(R.id.info_passport_sex) as EditText
        val editPassBirth = findViewById(R.id.info_passport_birth) as EditText
        val editPassCitizenship = findViewById(R.id.info_passport_citizenship) as EditText
        val editPassSeria = findViewById(R.id.info_passport_seria) as EditText
        val editPassNumber = findViewById(R.id.info_passport_number) as EditText
        val editPassDateReg = findViewById(R.id.info_passport_datereg) as EditText
        val editPassPeopleReg = findViewById(R.id.info_passport_peoplereg) as EditText
        val editPassPlace = findViewById(R.id.info_passport_place) as EditText

        viewModel.docks.observe(this, Observer { tours ->
            editName.isEnabled = false
            editName.setText(tours?.fullname)
            editPhone.isEnabled = false
            editPhone.setText(tours?.phone_number)
            //  паспорт
            if(tours.passport != null) {
                editPassName.isEnabled = false
                editPassName.setText(tours.passport?.fullname)
                editPassSex.isEnabled = false
                editPassSex.setText(tours.passport?.sex)
                editPassBirth.isEnabled = false
                editPassBirth.setText(tours.passport?.date_of_birth)
                editPassCitizenship.isEnabled = false
                editPassCitizenship.setText(tours.passport?.citizenship)
                editPassSeria.isEnabled = false
                editPassSeria.setText(tours.passport!!.serial)
                editPassNumber.isEnabled = false
                editPassNumber.setText(tours.passport!!.number)
                editPassDateReg.isEnabled = false
                editPassDateReg.setText(tours.passport!!.date_of_given)
                editPassPeopleReg.isEnabled = false
                editPassPeopleReg.setText(tours.passport!!.who_gave)
                editPassPlace.isEnabled = false
                editPassPlace.setText(tours.passport!!.registration)
                //        ОТМЕНА И СОХРАНИТЬ - паспорт
                cancelPassButton.visibility = View.GONE
                savePassButton.visibility = View.GONE
            }
        })

        editInfoButton.setOnClickListener {
            editName.isEnabled = true
            editPhone.isEnabled = true
            cancelInfoButton.visibility = View.VISIBLE
            saveInfoButton.visibility = View.VISIBLE
        }
        saveInfoButton.setOnClickListener {
            name = editName.text.toString()
            phone = editPhone.text.toString()
            binding.infoName.setText(name)
            binding.infoPhone.setText(phone)
            cancelInfoButton.visibility = View.GONE
            saveInfoButton.visibility = View.GONE
            editName.isEnabled = false
            editPhone.isEnabled = false
            viewModel.setPersInfo(user_id,name,phone)
            touristviewModel.getDocks(token)
//            viewModel.getDocksInfo(user_id)
        }
        cancelInfoButton.setOnClickListener {
            cancelInfoButton.visibility = View.GONE
            saveInfoButton.visibility = View.GONE
            editName.isEnabled = false
            editPhone.isEnabled = false
        }

        //        Кнопка - редактировать для паспорта
        editPassButton.setOnClickListener {
            //  паспорт
            editPassName.isEnabled = true
            editPassSex.isEnabled = true
            editPassBirth.isEnabled = true
            editPassCitizenship.isEnabled = true
            editPassSeria.isEnabled = true
            editPassNumber.isEnabled = true
            editPassDateReg.isEnabled = true
            editPassPeopleReg.isEnabled = true
            editPassPlace.isEnabled = true
            //        ОТМЕНА И СОХРАНИТЬ - паспорт
            cancelPassButton.visibility = View.VISIBLE
            savePassButton.visibility = View.VISIBLE
        }
        savePassButton.setOnClickListener {
            fullname = editPassName.text.toString()
            sex = editPassSex.text.toString()
            dob = editPassBirth.text.toString()
            citizenship = editPassCitizenship.text.toString()
            serial = editPassSeria.text.toString()
            number = editPassNumber.text.toString()
            dog = editPassDateReg.text.toString()
            wg = editPassPeopleReg.text.toString()
            registration = editPassPlace.text.toString()

            binding.infoPassportName.setText(fullname)
            binding.infoPassportSex.setText(sex)
            binding.infoPassportBirth.setText(dob)
            binding.infoPassportCitizenship.setText(citizenship)
            binding.infoPassportSeria.setText(serial)
            binding.infoPassportNumber.setText(number)
            binding.infoPassportDatereg.setText(dog)
            binding.infoPassportPeoplereg.setText(wg)
            binding.infoPassportPlace.setText(registration)

            cancelPassButton.visibility = View.GONE
            savePassButton.visibility = View.GONE

            editPassName.isEnabled = false
            editPassSex.isEnabled = false
            editPassBirth.isEnabled = false
            editPassCitizenship.isEnabled = false
            editPassSeria.isEnabled = false
            editPassNumber.isEnabled = false
            editPassDateReg.isEnabled = false
            editPassPeopleReg.isEnabled = false
            editPassPlace.isEnabled = false
            viewModel.uploadDocks(sharedPref.getString("doc_token", null)!!, fullname, sex, dob, citizenship, serial, number, dog, wg, registration)
        }
        cancelPassButton.setOnClickListener {
            cancelPassButton.visibility = View.GONE
            savePassButton.visibility = View.GONE

            editPassName.isEnabled = false
            editPassSex.isEnabled = false
            editPassBirth.isEnabled = false
            editPassCitizenship.isEnabled = false
            editPassSeria.isEnabled = false
            editPassNumber.isEnabled = false
            editPassDateReg.isEnabled = false
            editPassPeopleReg.isEnabled = false
            editPassPlace.isEnabled = false
        }
    }
}