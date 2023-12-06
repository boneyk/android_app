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
        val editZagrButton = findViewById<View>(R.id.zagr_edit_button) as Button
        val editVisaButton = findViewById<View>(R.id.visa_edit_button) as Button
        val editInsuranceButton = findViewById<View>(R.id.insurance_edit_button) as Button

        val cancelPassButton = findViewById<View>(R.id.pass_cancelbutton) as Button
        val cancelZagrButton = findViewById<View>(R.id.zagr_cancelbutton) as Button
        val cancelVisaButton = findViewById<View>(R.id.visa_cancelbutton) as Button
        val cancelInsuranceButton = findViewById<View>(R.id.insurance_cancelbutton) as Button

        val savePassButton = findViewById<View>(R.id.pass_okbutton) as Button
        val saveZagrButton = findViewById<View>(R.id.zagr_okbutton) as Button
        val saveVisaButton = findViewById<View>(R.id.visa_okbutton) as Button
        val saveInsuranceButton = findViewById<View>(R.id.insurance_okbutton) as Button

        cancelPassButton.setOnClickListener{
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
        cancelZagrButton.setOnClickListener{
            val zagrCancel = findViewById<View>(R.id.zagr_cancelbutton)
            zagrCancel.visibility = View.GONE
            val zagrSave = findViewById<View>(R.id.zagr_okbutton)
            zagrSave.visibility = View.GONE
            val editZagrName = findViewById<View>(R.id.info_zagr_name) as EditText
            editZagrName.isEnabled = false
            val editZagrSex = findViewById<View>(R.id.info_zagr_sex) as EditText
            editZagrSex.isEnabled = false
            val editZagrBirth = findViewById<View>(R.id.info_zagr_birth) as EditText
            editZagrBirth.isEnabled = false
            val editZagrCitizenship = findViewById<View>(R.id.info_zagr_citizenship) as EditText
            editZagrCitizenship.isEnabled = false
            val editZagrSeria = findViewById<View>(R.id.info_zagr_seria) as EditText
            editZagrSeria.isEnabled = false
            val editZagrNumber = findViewById<View>(R.id.info_zagr_number) as EditText
            editZagrNumber.isEnabled = false
            val editZagrDateReg = findViewById<View>(R.id.info_zagr_datereg) as EditText
            editZagrDateReg.isEnabled = false
            val editZagrPeopleReg = findViewById<View>(R.id.info_zagr_peoplereg) as EditText
            editZagrPeopleReg.isEnabled = false
        }

        cancelVisaButton.setOnClickListener{
            val visaCancel = findViewById<View>(R.id.visa_cancelbutton)
            visaCancel.visibility = View.GONE
            val visaSave = findViewById<View>(R.id.visa_okbutton)
            visaSave.visibility = View.GONE
            val editVisaName = findViewById<View>(R.id.info_visa_name) as EditText
            editVisaName.isEnabled = false
            val editVisaSex = findViewById<View>(R.id.info_visa_sex) as EditText
            editVisaSex.isEnabled = false
            val editVisaBirth = findViewById<View>(R.id.info_visa_birth) as EditText
            editVisaBirth.isEnabled = false
            val editVisaCitizenship = findViewById<View>(R.id.info_visa_citizenship) as EditText
            editVisaCitizenship.isEnabled = false
            val editVisaSeria = findViewById<View>(R.id.info_visa_seria) as EditText
            editVisaSeria.isEnabled = false
            val editVisaNumber = findViewById<View>(R.id.info_visa_number) as EditText
            editVisaNumber.isEnabled = false
            val editVisaDateReg = findViewById<View>(R.id.info_visa_datereg) as EditText
            editVisaDateReg.isEnabled = false
            val editVisaStart = findViewById<View>(R.id.info_visa_dataStart) as EditText
            editVisaStart.isEnabled = false
            val editVisaEnd = findViewById<View>(R.id.info_visa_dataEnd) as EditText
            editVisaEnd.isEnabled = false
            val editVisaPeopleReg = findViewById<View>(R.id.info_visa_peoplereg) as EditText
            editVisaPeopleReg.isEnabled = false
            val editVisaCountry = findViewById<View>(R.id.info_visa_country) as EditText
            editVisaCountry.isEnabled = false
            val editVisaDuration = findViewById<View>(R.id.info_visa_duration) as EditText
            editVisaDuration.isEnabled = false
            val editVisaPurpose = findViewById<View>(R.id.info_visa_purpose) as EditText
            editVisaPurpose.isEnabled = false
        }
        cancelInsuranceButton.setOnClickListener{
            val insuranceCancel = findViewById<View>(R.id.insurance_cancelbutton)
            insuranceCancel.visibility = View.GONE
            val insuranceSave = findViewById<View>(R.id.insurance_okbutton)
            insuranceSave.visibility = View.GONE
            val editInsuranceName = findViewById<View>(R.id.info_insurance_name) as EditText
            editInsuranceName.isEnabled = false
            val editInsuranceCover = findViewById<View>(R.id.info_insurance_areacover) as EditText
            editInsuranceCover.isEnabled = false
            val editInsuranceStart = findViewById<View>(R.id.info_insurance_dataStart) as EditText
            editInsuranceStart.isEnabled = false
            val editInsuranceEnd = findViewById<View>(R.id.info_insurance_dataEnd) as EditText
            editInsuranceEnd.isEnabled = false
            val editInsuranceCounty = findViewById<View>(R.id.info_insurance_countydays) as EditText
            editInsuranceCounty.isEnabled = false
            val editInsurancePrice = findViewById<View>(R.id.info_insurance_price) as EditText
            editInsurancePrice.isEnabled = false
        }
        savePassButton.setOnClickListener{
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
        saveZagrButton.setOnClickListener{
            val zagrCancel = findViewById<View>(R.id.zagr_cancelbutton)
            zagrCancel.visibility = View.GONE
            val zagrSave = findViewById<View>(R.id.zagr_okbutton)
            zagrSave.visibility = View.GONE
            val editZagrName = findViewById<View>(R.id.info_zagr_name) as EditText
            editZagrName.isEnabled = false
            val editZagrSex = findViewById<View>(R.id.info_zagr_sex) as EditText
            editZagrSex.isEnabled = false
            val editZagrBirth = findViewById<View>(R.id.info_zagr_birth) as EditText
            editZagrBirth.isEnabled = false
            val editZagrCitizenship = findViewById<View>(R.id.info_zagr_citizenship) as EditText
            editZagrCitizenship.isEnabled = false
            val editZagrSeria = findViewById<View>(R.id.info_zagr_seria) as EditText
            editZagrSeria.isEnabled = false
            val editZagrNumber = findViewById<View>(R.id.info_zagr_number) as EditText
            editZagrNumber.isEnabled = false
            val editZagrDateReg = findViewById<View>(R.id.info_zagr_datereg) as EditText
            editZagrDateReg.isEnabled = false
            val editZagrPeopleReg = findViewById<View>(R.id.info_zagr_peoplereg) as EditText
            editZagrPeopleReg.isEnabled = false
        }
        saveVisaButton.setOnClickListener{
            val visaCancel = findViewById<View>(R.id.visa_cancelbutton)
            visaCancel.visibility = View.GONE
            val visaSave = findViewById<View>(R.id.visa_okbutton)
            visaSave.visibility = View.GONE
            val editVisaName = findViewById<View>(R.id.info_visa_name) as EditText
            editVisaName.isEnabled = false
            val editVisaSex = findViewById<View>(R.id.info_visa_sex) as EditText
            editVisaSex.isEnabled = false
            val editVisaBirth = findViewById<View>(R.id.info_visa_birth) as EditText
            editVisaBirth.isEnabled = false
            val editVisaCitizenship = findViewById<View>(R.id.info_visa_citizenship) as EditText
            editVisaCitizenship.isEnabled = false
            val editVisaSeria = findViewById<View>(R.id.info_visa_seria) as EditText
            editVisaSeria.isEnabled = false
            val editVisaNumber = findViewById<View>(R.id.info_visa_number) as EditText
            editVisaNumber.isEnabled = false
            val editVisaDateReg = findViewById<View>(R.id.info_visa_datereg) as EditText
            editVisaDateReg.isEnabled = false
            val editVisaStart = findViewById<View>(R.id.info_visa_dataStart) as EditText
            editVisaStart.isEnabled = false
            val editVisaEnd = findViewById<View>(R.id.info_visa_dataEnd) as EditText
            editVisaEnd.isEnabled = false
            val editVisaPeopleReg = findViewById<View>(R.id.info_visa_peoplereg) as EditText
            editVisaPeopleReg.isEnabled = false
            val editVisaCountry = findViewById<View>(R.id.info_visa_country) as EditText
            editVisaCountry.isEnabled = false
            val editVisaDuration = findViewById<View>(R.id.info_visa_duration) as EditText
            editVisaDuration.isEnabled = false
            val editVisaPurpose = findViewById<View>(R.id.info_visa_purpose) as EditText
            editVisaPurpose.isEnabled = false
        }
        saveInsuranceButton.setOnClickListener{
            val insuranceCancel = findViewById<View>(R.id.insurance_cancelbutton)
            insuranceCancel.visibility = View.GONE
            val insuranceSave = findViewById<View>(R.id.insurance_okbutton)
            insuranceSave.visibility = View.GONE
            val editInsuranceName = findViewById<View>(R.id.info_insurance_name) as EditText
            editInsuranceName.isEnabled = false
            val editInsuranceCover = findViewById<View>(R.id.info_insurance_areacover) as EditText
            editInsuranceCover.isEnabled = false
            val editInsuranceStart = findViewById<View>(R.id.info_insurance_dataStart) as EditText
            editInsuranceStart.isEnabled = false
            val editInsuranceEnd = findViewById<View>(R.id.info_insurance_dataEnd) as EditText
            editInsuranceEnd.isEnabled = false
            val editInsuranceCounty = findViewById<View>(R.id.info_insurance_countydays) as EditText
            editInsuranceCounty.isEnabled = false
            val editInsurancePrice = findViewById<View>(R.id.info_insurance_price) as EditText
            editInsurancePrice.isEnabled = false
        }
//        Кнопка - редактировать для паспорта
        editPassButton.setOnClickListener{
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
        //   Кнопка - редактировать для загранпаспорта
        editZagrButton.setOnClickListener{
            val editZagrName = findViewById<View>(R.id.info_zagr_name) as EditText
            editZagrName.isEnabled = true
            val editZagrSex = findViewById<View>(R.id.info_zagr_sex) as EditText
            editZagrSex.isEnabled = true
            val editZagrBirth = findViewById<View>(R.id.info_zagr_birth) as EditText
            editZagrBirth.isEnabled = true
            val editZagrCitizenship = findViewById<View>(R.id.info_zagr_citizenship) as EditText
            editZagrCitizenship.isEnabled = true
            val editZagrSeria = findViewById<View>(R.id.info_zagr_seria) as EditText
            editZagrSeria.isEnabled = true
            val editZagrNumber = findViewById<View>(R.id.info_zagr_number) as EditText
            editZagrNumber.isEnabled = true
            val editZagrDateReg = findViewById<View>(R.id.info_zagr_datereg) as EditText
            editZagrDateReg.isEnabled = true
            val editZagrPeopleReg = findViewById<View>(R.id.info_zagr_peoplereg) as EditText
            editZagrPeopleReg.isEnabled = true
//        ОТМЕНА И СОХРАНИТЬ - загранпаспорт
            val zagrCancel = findViewById<View>(R.id.zagr_cancelbutton)
            zagrCancel.visibility = View.VISIBLE
            val zagrSave = findViewById<View>(R.id.zagr_okbutton)
            zagrSave.visibility = View.VISIBLE
        }
        //    Кнопка - редактировать для визы
        editVisaButton.setOnClickListener{
            val editVisaName = findViewById<View>(R.id.info_visa_name) as EditText
            editVisaName.isEnabled = true
            val editVisaSex = findViewById<View>(R.id.info_visa_sex) as EditText
            editVisaSex.isEnabled = true
            val editVisaBirth = findViewById<View>(R.id.info_visa_birth) as EditText
            editVisaBirth.isEnabled = true
            val editVisaCitizenship = findViewById<View>(R.id.info_visa_citizenship) as EditText
            editVisaCitizenship.isEnabled = true
            val editVisaSeria = findViewById<View>(R.id.info_visa_seria) as EditText
            editVisaSeria.isEnabled = true
            val editVisaNumber = findViewById<View>(R.id.info_visa_number) as EditText
            editVisaNumber.isEnabled = true
            val editVisaDateReg = findViewById<View>(R.id.info_visa_datereg) as EditText
            editVisaDateReg.isEnabled = true
            val editVisaStart = findViewById<View>(R.id.info_visa_dataStart) as EditText
            editVisaStart.isEnabled = true
            val editVisaEnd = findViewById<View>(R.id.info_visa_dataEnd) as EditText
            editVisaEnd.isEnabled = true
            val editVisaPeopleReg = findViewById<View>(R.id.info_visa_peoplereg) as EditText
            editVisaPeopleReg.isEnabled = true
            val editVisaCountry = findViewById<View>(R.id.info_visa_country) as EditText
            editVisaCountry.isEnabled = true
            val editVisaDuration = findViewById<View>(R.id.info_visa_duration) as EditText
            editVisaDuration.isEnabled = true
            val editVisaPurpose = findViewById<View>(R.id.info_visa_purpose) as EditText
            editVisaPurpose.isEnabled = true
            //        ОТМЕНА И СОХРАНИТЬ - виза
            val visaCancel = findViewById<View>(R.id.visa_cancelbutton)
            visaCancel.visibility = View.VISIBLE
            val visaSave = findViewById<View>(R.id.visa_okbutton)
            visaSave.visibility = View.VISIBLE
        }
        //    Кнопка - редактировать для страховки
        editInsuranceButton.setOnClickListener{
            val editInsuranceName = findViewById<View>(R.id.info_insurance_name) as EditText
            editInsuranceName.isEnabled = true
            val editInsuranceCover = findViewById<View>(R.id.info_insurance_areacover) as EditText
            editInsuranceCover.isEnabled = true
            val editInsuranceStart = findViewById<View>(R.id.info_insurance_dataStart) as EditText
            editInsuranceStart.isEnabled = true
            val editInsuranceEnd = findViewById<View>(R.id.info_insurance_dataEnd) as EditText
            editInsuranceEnd.isEnabled = true
            val editInsuranceCounty = findViewById<View>(R.id.info_insurance_countydays) as EditText
            editInsuranceCounty.isEnabled = true
            val editInsurancePrice = findViewById<View>(R.id.info_insurance_price) as EditText
            editInsurancePrice.isEnabled = true
            //        ОТМЕНА И СОХРАНИТЬ - страховка
            val insuranceCancel = findViewById<View>(R.id.insurance_cancelbutton)
            insuranceCancel.visibility = View.VISIBLE
            val insuranceSave = findViewById<View>(R.id.insurance_okbutton)
            insuranceSave.visibility = View.VISIBLE
        }

//        ОТМЕНА И СОХРАНИТЬ - паспорт
        val passCancel = findViewById<View>(R.id.pass_cancelbutton)
        passCancel.visibility = View.GONE
        val passSave = findViewById<View>(R.id.pass_okbutton)
        passSave.visibility = View.GONE
//        ОТМЕНА И СОХРАНИТЬ - загранпаспорт
        val zagrCancel = findViewById<View>(R.id.zagr_cancelbutton)
        zagrCancel.visibility = View.GONE
        val zagrSave = findViewById<View>(R.id.zagr_okbutton)
        zagrSave.visibility = View.GONE
//        ОТМЕНА И СОХРАНИТЬ - виза
        val visaCancel = findViewById<View>(R.id.visa_cancelbutton)
        visaCancel.visibility = View.GONE
        val visaSave = findViewById<View>(R.id.visa_okbutton)
        visaSave.visibility = View.GONE
//        ОТМЕНА И СОХРАНИТЬ - страховка
        val insuranceCancel = findViewById<View>(R.id.insurance_cancelbutton)
        insuranceCancel.visibility = View.GONE
        val insuranceSave = findViewById<View>(R.id.insurance_okbutton)
        insuranceSave.visibility = View.GONE
//  паспорт
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
//  загранпаспорт
        val editZagrName = findViewById<View>(R.id.info_zagr_name) as EditText
        editZagrName.isEnabled = false
        val editZagrSex = findViewById<View>(R.id.info_zagr_sex) as EditText
        editZagrSex.isEnabled = false
        val editZagrBirth = findViewById<View>(R.id.info_zagr_birth) as EditText
        editZagrBirth.isEnabled = false
        val editZagrCitizenship = findViewById<View>(R.id.info_zagr_citizenship) as EditText
        editZagrCitizenship.isEnabled = false
        val editZagrSeria = findViewById<View>(R.id.info_zagr_seria) as EditText
        editZagrSeria.isEnabled = false
        val editZagrNumber = findViewById<View>(R.id.info_zagr_number) as EditText
        editZagrNumber.isEnabled = false
        val editZagrDateReg = findViewById<View>(R.id.info_zagr_datereg) as EditText
        editZagrDateReg.isEnabled = false
        val editZagrPeopleReg = findViewById<View>(R.id.info_zagr_peoplereg) as EditText
        editZagrPeopleReg.isEnabled = false
//  виза
        val editVisaName = findViewById<View>(R.id.info_visa_name) as EditText
        editVisaName.isEnabled = false
        val editVisaSex = findViewById<View>(R.id.info_visa_sex) as EditText
        editVisaSex.isEnabled = false
        val editVisaBirth = findViewById<View>(R.id.info_visa_birth) as EditText
        editVisaBirth.isEnabled = false
        val editVisaCitizenship = findViewById<View>(R.id.info_visa_citizenship) as EditText
        editVisaCitizenship.isEnabled = false
        val editVisaSeria = findViewById<View>(R.id.info_visa_seria) as EditText
        editVisaSeria.isEnabled = false
        val editVisaNumber = findViewById<View>(R.id.info_visa_number) as EditText
        editVisaNumber.isEnabled = false
        val editVisaDateReg = findViewById<View>(R.id.info_visa_datereg) as EditText
        editVisaDateReg.isEnabled = false
        val editVisaStart = findViewById<View>(R.id.info_visa_dataStart) as EditText
        editVisaStart.isEnabled = false
        val editVisaEnd = findViewById<View>(R.id.info_visa_dataEnd) as EditText
        editVisaEnd.isEnabled = false
        val editVisaPeopleReg = findViewById<View>(R.id.info_visa_peoplereg) as EditText
        editVisaPeopleReg.isEnabled = false
        val editVisaCountry = findViewById<View>(R.id.info_visa_country) as EditText
        editVisaCountry.isEnabled = false
        val editVisaDuration = findViewById<View>(R.id.info_visa_duration) as EditText
        editVisaDuration.isEnabled = false
        val editVisaPurpose = findViewById<View>(R.id.info_visa_purpose) as EditText
        editVisaPurpose.isEnabled = false
//  страховка
        val editInsuranceName = findViewById<View>(R.id.info_insurance_name) as EditText
        editInsuranceName.isEnabled = false
        val editInsuranceCover = findViewById<View>(R.id.info_insurance_areacover) as EditText
        editInsuranceCover.isEnabled = false
        val editInsuranceStart = findViewById<View>(R.id.info_insurance_dataStart) as EditText
        editInsuranceStart.isEnabled = false
        val editInsuranceEnd = findViewById<View>(R.id.info_insurance_dataEnd) as EditText
        editInsuranceEnd.isEnabled = false
        val editInsuranceCounty = findViewById<View>(R.id.info_insurance_countydays) as EditText
        editInsuranceCounty.isEnabled = false
        val editInsurancePrice = findViewById<View>(R.id.info_insurance_price) as EditText
        editInsurancePrice.isEnabled = false
    }
}