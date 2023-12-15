package network_api

import com.example.travel_agency.models.LoginRequest
import com.example.travel_agency.models.RegRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface APIService {

    @POST("auth")
    fun loginUser(@Body user: LoginRequest): Call<Void>

    @POST("/api/auth/reg")
    fun regUser(@Body user: RegRequest): Call<Void>

//    @GET("/api/tours")
//    fun getTours(@Body user: LoginRequest): Call<Any>

}