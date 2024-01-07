package com.example.travel_agency

import android.content.Context
import android.util.Log
import com.example.travel_agency.models.LoginResponse
import com.example.travel_agency.models.PersInfo

class Memory(context: Context) {
    companion object {
        var user_id: String = "1"
        var tour_id : Int = 1
        var pers_info: PersInfo = PersInfo("1","1","1","1","1")
//        var conf_info: ConfirmResponse = ConfirmResponse()
    }
    fun saveUserId(id:LoginResponse){
        Log.d("MyLog", "значение2/3/1 = ${id}")
        user_id = id.token
    }
    fun getUserId() : String{
        Log.d("MyLog", "значение2/3 = ${user_id}")
        return user_id
    }

    fun saveTourId(id:Int){
        tour_id = id
    }
    fun getTourId() : Int{
        return tour_id
    }
}