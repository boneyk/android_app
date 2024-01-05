package com.example.travel_agency.ViewModel

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.travel_agency.Memory
import com.example.travel_agency.databinding.ActivityDockBinding
import com.example.travel_agency.databinding.FragmentProfileBinding
import com.example.travel_agency.models.DocksInfo
import com.example.travel_agency.models.PersInfo
import com.example.travel_agency.models.TourFav
import network_api.APIBuilder

class DocksViewModel(val context: Application) : AndroidViewModel(context) {
    private val apiService = APIBuilder()
    private val storage = Memory(context)
    var docks: MutableLiveData<DocksInfo> = MutableLiveData()

    fun tryUpdateDock(binding: ActivityDockBinding) {
        val name = binding.infoPassportName.text.toString()
        Log.d("MyLog", "имя = ${name}")
        val sex = binding.infoPassportSex.text.toString()
        val citizenship = binding.infoPassportCitizenship.text.toString()
        val serial = binding.infoPassportSeria.text.toString()
        val number = binding.infoPassportNumber.text.toString()
        val registration = binding.infoPassportPlace.text.toString()
        val date_of_birth = binding.infoPassportBirth.text.toString()
        val date_of_given = binding.infoPassportDatereg.text.toString()
        val who_gave = binding.infoPassportPeoplereg.text.toString()
        uploadDocks(storage.getUserId(),name,sex,citizenship,serial,number,registration,date_of_birth,date_of_given,who_gave)
    }
    fun getDocks(user_id: String){
        apiService.getDocks(user_id, object : APIBuilder.DockCallback{
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
    private fun uploadDocks(id : String, fullname:String,sex:String,
                            citizenship:String,serial:String,number:String,
                            registration:String,date_of_birth:String,date_of_given:String,
                            who_gave:String) {
        apiService.uploadDocks(id,fullname,sex,citizenship,serial,number,registration,date_of_birth,date_of_given,who_gave, object : APIBuilder.UpdateFaveCallback {
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