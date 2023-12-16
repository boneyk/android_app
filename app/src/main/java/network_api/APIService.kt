package network_api

import com.example.travel_agency.models.LoginRequest
import com.example.travel_agency.models.RegRequest
import com.example.travel_agency.models.Tour
import com.example.travel_agency.models.Tours
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface APIService {

    @POST("auth")
    fun loginUser(@Body user: LoginRequest): Call<Void>

    @POST("auth/reg")
    fun regUser(@Body user: RegRequest): Call<Void>

    @GET("tours")
    fun findTours(): Call<List<Tours>>

    @GET("tours/{id}")
    fun findTourWithId(@Path("id") id: Int): Call<Tour>

}