package com.example.travel_agency.ViewModel

import android.app.Application
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.travel_agency.adapters.TourListAdapter
import com.example.travel_agency.databinding.FragmentToursBinding
import com.example.travel_agency.fragments.ToursFragment
import com.example.travel_agency.models.Tour
import com.example.travel_agency.models.Tours
import network_api.InitAPI


class ToursFragmentViewModel(val context: Application) : AndroidViewModel(context) {
    lateinit var binding: FragmentToursBinding
    private val apiService = InitAPI()
    val tourList: MutableLiveData<List<Tours>> = MutableLiveData()

    fun tryTours() {
        apiService.findTours(object : InitAPI.ToursCallback {
            override fun onSuccess(response: List<Tours>) {
                if (response.isNotEmpty()){
                    Log.d("MyLog", "Запрос перешел в ToursVIewModel в функцию getTours()")
                    tourList.value = response
                }else{
                    Toast.makeText(context, "Сегодня в нашем агентстве нет туров :(", Toast.LENGTH_LONG).show()
                }
            }

            override fun onError() {
                Toast.makeText(context, "Возникла ошибка с получением туров", Toast.LENGTH_LONG).show()
            }

            override fun onFailure(error: Throwable) {
                Toast.makeText(context, "Ошибка подключения к серверу", Toast.LENGTH_LONG).show()
            }
        })
    }

}