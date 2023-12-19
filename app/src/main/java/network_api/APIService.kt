package network_api

import com.example.travel_agency.models.LoginRequest
import com.example.travel_agency.models.RegRequest
import com.example.travel_agency.models.Tour
import com.example.travel_agency.models.TourFav
import com.example.travel_agency.models.Tours
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface APIService {

    @POST("auth")
    fun loginUser(@Body user: LoginRequest): Call<Int>

    @POST("auth/reg")
    fun regUser(@Body user: RegRequest): Call<Int>

    @GET("tours")
    fun findTours(): Call<List<Tours>>

    @GET("tours/{id}")
    fun findTourWithId(@Path("id") id: Int): Call<Tour>

    @GET("tours/favorite")
    fun findFavTour(@Query("user_id") user_id: Int): Call<List<TourFav>>

    @PATCH("tours/favorite/{tour_id}/to/{user_id}")
    fun updateFave(@Path("tour_id") tour_id: Int, @Path("user_id") user_id: Int): Call<Void>

    @DELETE("tours/favorite/{tour_id}/from/{user_id}")
    fun deleteFave(@Path("tour_id") tour_id: Int, @Path("user_id") user_id: Int): Call<Void>

}