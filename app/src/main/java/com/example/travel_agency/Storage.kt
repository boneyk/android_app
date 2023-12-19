package com.example.travel_agency

import android.content.Context
import android.util.Log
import com.example.travel_agency.models.ConfirmResponse
import com.example.travel_agency.models.PersInfo

class Storage(context: Context) {
    companion object {
        var user_id: Int = 1
        var tour_id : Int = 1
        var pers_info: PersInfo = PersInfo("1","1","1","1","1")
//        var conf_info: ConfirmResponse = ConfirmResponse()
    }
    fun saveUserId(id:Int){
        Log.d("MyLog", "значение2/3/1 = ${id}")
        user_id = id
    }
    fun getUserId() : Int{
        Log.d("MyLog", "значение2/3 = ${user_id}")
        return user_id
    }

    fun saveTourId(id:Int){
        tour_id = id
    }
    fun getTourId() : Int{
        return tour_id
    }

    fun savePersInfo(info : PersInfo){
        pers_info = info
        Log.d("MyLog", "info в хранилище = ${pers_info.email}")
    }
    fun getPersInfo(): PersInfo{
        return pers_info
    }

//    fun saveConf(info : ConfirmResponse){
//        conf_info = info
//    }
//    fun getConf() : ConfirmResponse{
//        return conf_info
//    }
}