package network_api

import com.example.travel_agency.models.ConfRequest
import com.example.travel_agency.models.ConfirmResponse
import com.example.travel_agency.models.DockRequest
import com.example.travel_agency.models.DocksInfo
import com.example.travel_agency.models.Docksmall
import com.example.travel_agency.models.HistElement
import com.example.travel_agency.models.LoginRequest
import com.example.travel_agency.models.LoginResponse
import com.example.travel_agency.models.PersInfo
import com.example.travel_agency.models.Person
import com.example.travel_agency.models.ProfRequest
import com.example.travel_agency.models.RegRequest
import com.example.travel_agency.models.Tour
import com.example.travel_agency.models.TourFav
import com.example.travel_agency.models.TourResponse
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
    fun findTourWithId(@Path("id") id: Int, @Query("token") user_id: String): Call<TourResponse>

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
    fun putUserInfo(@Query("token") user_id: String, @Body request : ProfRequest): Call<LoginResponse>

    //получение списка туров из истории покупок
    @GET("trip/history")
    fun findHistTour(@Query("token") user_id: String): Call<List<HistElement>>

    //получение информации о пользователе и туре для подтверждения покупки
    @POST("trip")
    fun orderTour(@Body request : ConfRequest): Call<ConfirmResponse>

    //добавление тура в историю покупки определенного пользователя
    @POST("trip/add")
    fun updateHist(@Body request : ConfRequest): Call<Any>

    //получение списка туристов
    @GET("documents")
    fun getDocks(@Query("token") user_id: String): Call<List<Person>>

//   добавление нового туриста
    @POST("documents/add")
    fun putPeop(@Query("token") user_id: String): Call<LoginResponse>

    @GET("documents/person")
    fun getDocksInfo(@Query("doc_token") doc_token: String): Call<DocksInfo>

    //добавление личных документов пользователя
//    @POST("documents/personalInfo")
//    fun uploadDocks(@Query("doc_token") user_id: String, @Body request : Docksmall): Call<Void>

    @POST("documents/personalInfo")
    fun setPersInfo(@Query("doc_token") user_id: String, @Body request : Docksmall): Call<Void>
}