package com.example.travel_agency.ViewModel

import android.app.Application
import android.content.SharedPreferences
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.travel_agency.databinding.ActivityDockBinding
import com.example.travel_agency.databinding.FragmentProfileBinding
import com.example.travel_agency.models.DocksInfo
import com.example.travel_agency.models.Docksmall
import com.example.travel_agency.models.PersInfo
import com.example.travel_agency.models.TourFav
import network_api.APIBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DocksViewModel(val context: Application) : AndroidViewModel(context) {
    private val apiService = APIBuilder()
    var docks: MutableLiveData<DocksInfo> = MutableLiveData()

    private lateinit var sharedPref: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor
    fun tryUpdateDock(binding: ActivityDockBinding) {
        sharedPref = context.getSharedPreferences("myPref", AppCompatActivity.MODE_PRIVATE)
        editor = sharedPref.edit()
        val fullname = binding.infoPassportName.text.toString()
        Log.d("MyLog", "имя = ${fullname}")
        val sex = binding.infoPassportSex.text.toString()
        val dob = binding.infoPassportBirth.text.toString()
        val citizenship = binding.infoPassportCitizenship.text.toString()
        val serial = binding.infoPassportSeria.text.toString()
        val number = binding.infoPassportNumber.text.toString()
        val dog = binding.infoPassportDatereg.text.toString()
        val wg = binding.infoPassportPeoplereg.text.toString()
        val registration = binding.infoPassportPlace.text.toString()
        uploadDocks(sharedPref.getString("doc_token", null)!!, fullname, sex, dob, citizenship, serial, number, dog, wg, registration)
    }
    fun getDocksInfo(user_id: String){
        apiService.getDocksInfo(user_id, object : APIBuilder.DockInfoCallback{
            override fun onSuccess(response: DocksInfo) {
                docks.value = response
            }

            override fun onError() {
                Toast.makeText(context, "В документах еще нет паспорта", Toast.LENGTH_LONG).show()
            }

            override fun onFailure(error: Throwable) {
                Toast.makeText(context, "Ошибка подключения к серверу", Toast.LENGTH_LONG).show()
            }
        })
    }
    fun setPersInfo(user_id: String, fullname: String,
                    phone_number:String){
        apiService.setPersInfo(user_id,fullname,phone_number, object : APIBuilder.UpdateDocksCallback{
            override fun onSuccess() {
                Toast.makeText(context, "Информация успешно обновлена", Toast.LENGTH_LONG).show()
            }

            override fun onError() {
                Toast.makeText(context, "Произошла ошибка с обновлением информации", Toast.LENGTH_LONG).show()
            }

            override fun onFailure(error: Throwable) {
                Toast.makeText(context, "Ошибка подключения к серверу", Toast.LENGTH_LONG).show()
            }
        })
    }
    private fun uploadDocks(id : String, fullname:String,sex:String,dob:String,
                            citizenship:String,serial:String,number:String,
                            dog:String,wg:String, registration:String) {
        apiService.uploadDocks(id,fullname,sex,dob,citizenship,serial,number,dog,wg,registration,object : APIBuilder.UpdateDocksCallback {
            override fun onSuccess() {
                Toast.makeText(context, "Информация успешно обновлена", Toast.LENGTH_LONG).show()
            }

            override fun onError() {
                Toast.makeText(context, "Ошибка при обновлении паспорта", Toast.LENGTH_LONG).show()
            }

            override fun onFailure(error: Throwable) {
                Toast.makeText(context, "Ошибка подключения", Toast.LENGTH_LONG).show()
            }
        })
    }
}