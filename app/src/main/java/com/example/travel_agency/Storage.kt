package com.example.travel_agency

import android.content.Context
import android.util.Log

class Storage(context: Context) {
    companion object {
        var user_id: Int = 1
        var tour_id : Int = 1
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
}