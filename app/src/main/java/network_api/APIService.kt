package network_api

import com.example.travel_agency.models.ConfirmResponse
import com.example.travel_agency.models.DockRequest
import com.example.travel_agency.models.DocksInfo
import com.example.travel_agency.models.LoginRequest
import com.example.travel_agency.models.LoginResponse
import com.example.travel_agency.models.PersInfo
import com.example.travel_agency.models.ProfRequest
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

    //авторизация
    @POST("auth")
    fun loginUser(@Body user: LoginRequest): Call<LoginResponse>

    //регистрация
    @POST("auth/reg")
    fun regUser(@Body user: RegRequest): Call<LoginResponse>

    //получение всех туров
    @GET("tours")
    fun findTours(): Call<List<Tours>>

    //получение определенного тура по его id
    @GET("tours/{id}")
    fun findTourWithId(@Path("id") id: Int): Call<Tour>

    //получение списка туров из избранного
    @GET("tours/favorite")
    fun findFavTour(@Query("token") user_id: String): Call<List<TourFav>>

    //добавление определенного тура в избранное определенному пользователю
    @PATCH("tours/favorite/{tour_id}/to/{token}")
    fun updateFave(@Path("tour_id") tour_id: Int, @Path("token") user_id: String): Call<Void>

    //удаление определенного тура из избранного определенного пользователя
    @DELETE("tours/favorite/{tour_id}/from/{token}")
    fun deleteFave(@Path("tour_id") tour_id: Int, @Path("token") user_id: String): Call<Void>

    //получение личной информации о пользователе для личного кабинета
    @GET("users/info")
    fun getUserInfo(@Query("token") user_id: String): Call<PersInfo>

    //добавление личной информации о пользователе в личном кабинете
    @PATCH("users/info")
    fun putUserInfo(@Query("token") user_id: String, @Body request : ProfRequest): Call<Void>

    //получение списка туров из истории покупок
    @GET("tours/history")
    fun findHistTour(@Query("token") user_id: String): Call<List<TourFav>>

    //получение информации о пользователе и туре для подтверждения покупки
    @GET("tours/order")
    fun orderTour(@Query("token") user_id: String, @Query("tour_id") tour_id : Int): Call<ConfirmResponse>

    //добавление тура в историю покупки определенного пользователя
    @PATCH("tours/history/{tour_id}/to/{token}")
    fun updateHist(@Path("tour_id") tour_id: Int, @Path("token") user_id: String): Call<Void>

    //получение личных документов пользователя
    @GET("documents")
    fun getDocks(@Query("token") user_id: String): Call<DocksInfo>

    //добавление личных документов пользователя
    @PATCH("documents/passport")
    fun uploadDocks(@Query("token") user_id: String, @Body request : DockRequest): Call<Void>
}