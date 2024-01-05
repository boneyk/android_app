package network_api

import android.util.Log
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
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class APIBuilder(){
    private val url: String = "http://89.223.122.223:8080/api/"
    private val interceptor = HttpLoggingInterceptor()
    private val client = OkHttpClient.Builder().addInterceptor(interceptor).build()


    private val retrofit = Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()
    private val api: APIService = retrofit.create(APIService::class.java)
    fun getAPI(): APIService {
        return this.api
    }

    interface LoginCallback {
        fun onSuccess(response: LoginResponse)
        fun onError()
        fun onFailure(error: Throwable)
    }
    interface RegCallback {
        fun onSuccess(response: LoginResponse)
        fun onError()
        fun onFailure(error: Throwable)
    }
    interface ToursCallback {
        fun onSuccess(response: List<Tours>)
        fun onError()
        fun onFailure(error: Throwable)
    }
    interface TourCallback {
        fun onSuccess(response: Tour)
        fun onError()
        fun onFailure(error: Throwable)
    }
    interface TourFavCallback {
        fun onSuccess(response: List<TourFav>)
        fun onError()
        fun onFailure(error: Throwable)
    }
    interface UpdateFaveCallback {
        fun onSuccess()
        fun onError()
        fun onFailure(error: Throwable)
    }
    interface InfoCallback {
        fun onSuccess(response: PersInfo)
        fun onError()
        fun onFailure(error: Throwable)
    }
    interface ProfCallback {
        fun onSuccess()
        fun onError()
        fun onFailure(error: Throwable)
    }
    interface ConfCallback {
        fun onSuccess(response: ConfirmResponse)
        fun onError()
        fun onFailure(error: Throwable)
    }
    interface DockCallback {
        fun onSuccess(response: DocksInfo)
        fun onError()
        fun onFailure(error: Throwable)
    }

    fun loginUser(login: String, password: String, callback: LoginCallback) {

        api.loginUser(LoginRequest(login, password))
            .enqueue(object : Callback<LoginResponse> {
                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {
                    if (response.isSuccessful) {
                        Log.d("MyLog", "значение = $response.body()!!")
                        callback.onSuccess(response.body()!!)
                    } else {
                        callback.onError()
                    }
                }


                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    callback.onFailure(t)
                    Log.d("MyLog", "Ошибка при выполнении запроса: ${t.message}")
                    callback.onFailure(t)
//                    Log.d("MyLog", "login: ${t.message}")
                }

            })
    }
    fun regUser(login: String, email: String, password: String, password_confirm: String, callback: RegCallback){
        api.regUser(RegRequest(login,email,password,password_confirm))
            .enqueue(object : Callback<LoginResponse> {
                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {
                    if (response.isSuccessful) {
                        callback.onSuccess(response.body()!!)
                    } else {
                        callback.onError()
                    }
                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    callback.onFailure(t)
                    Log.d("MyLog", "Ошибка при выполнении запроса: ${t.message}")
                    callback.onFailure(t)
                }
            })
    }
    fun findTours(callback: ToursCallback){
        api.findTours()
            .enqueue(object : Callback<List<Tours>> {
                override fun onResponse(
                    call: Call<List<Tours>>,
                    response: Response<List<Tours>>
                ) {
                    if (response.isSuccessful) {
                        callback.onSuccess(response.body()!!)
                    } else {
                        callback.onError()
                    }
                }

                override fun onFailure(call: Call<List<Tours>>, t: Throwable) {
                    callback.onFailure(t)
                    Log.d("MyLog", "Ошибка при выполнении запроса: ${t.message}")
                }
            })
    }
    fun findTourWithId(id: Int, callback: TourCallback){
        api.findTourWithId(id)
            .enqueue(object : Callback<Tour> {
                override fun onResponse(
                    call: Call<Tour>,
                    response: Response<Tour>
                ) {
                    if (response.isSuccessful) {
                        callback.onSuccess(response.body()!!)
                    } else {
                        callback.onError()
                    }
                }

                override fun onFailure(call: Call<Tour>, t: Throwable) {
                    callback.onFailure(t)
                    Log.d("MyLog", "Ошибка при выполнении запроса: ${t.message}")
                }
            })
    }
    fun findFavTour(user_id: String, callback: TourFavCallback){
        api.findFavTour(user_id)
            .enqueue(object : Callback <List<TourFav>> {
                override fun onResponse(
                    call: Call<List<TourFav>>,
                    response: Response<List<TourFav>>
                ) {
                    if (response.isSuccessful) {
                        callback.onSuccess(response.body()!!)
                    } else {
                        callback.onError()
                    }
                }

                override fun onFailure(call: Call<List<TourFav>>, t: Throwable) {
                    callback.onFailure(t)
                    Log.d("MyLog", "Ошибка при выполнении запроса: ${t.message}")
                }
            })
    }

    fun updateFave(tour_id: Int, user_id: String, callback: UpdateFaveCallback){
        api.updateFave(tour_id, user_id)
            .enqueue(object : Callback <Void> {
                override fun onResponse(
                    call: Call<Void>,
                    response: Response<Void>
                ) {
                    if (response.isSuccessful) {
                        callback.onSuccess()
                    } else {
                        callback.onError()
                    }
                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    callback.onFailure(t)
                    Log.d("MyLog", "Ошибка при выполнении запроса: ${t.message}")
                }
            })
    }

    fun deleteFave(tour_id: Int, user_id: String, callback: UpdateFaveCallback){
        api.deleteFave(tour_id, user_id)
            .enqueue(object : Callback <Void> {
                override fun onResponse(
                    call: Call<Void>,
                    response: Response<Void>
                ) {
                    if (response.isSuccessful) {
                        callback.onSuccess()
                    } else {
                        callback.onError()
                    }
                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    callback.onFailure(t)
                    Log.d("MyLog", "Ошибка при выполнении запроса: ${t.message}")
                }
            })
    }
    fun getUserInfo(id: String, callback: InfoCallback){
        api.getUserInfo(id)
            .enqueue(object : Callback<PersInfo> {
                override fun onResponse(
                    call: Call<PersInfo>,
                    response: Response<PersInfo>
                ) {
                    if (response.isSuccessful) {
                        callback.onSuccess(response.body()!!)
                    } else {
                        callback.onError()
                    }
                }

                override fun onFailure(call: Call<PersInfo>, t: Throwable) {
                    callback.onFailure(t)
                    Log.d("MyLog", "Ошибка при выполнении запроса: ${t.message}")
                }
            })
    }

    fun putUserInfo(user_id: String,name : String, phone : String, callback: ProfCallback){
        api.putUserInfo(user_id, ProfRequest(name,phone))
            .enqueue(object : Callback <Void> {
                override fun onResponse(
                    call: Call<Void>,
                    response: Response<Void>
                ) {
                    if (response.isSuccessful) {
                        callback.onSuccess()
                    } else {
                        callback.onError()
                    }
                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    callback.onFailure(t)
                    Log.d("MyLog", "Ошибка при выполнении запроса: ${t.message}")
                }
            })
    }
    fun findHistTour(user_id: String, callback: TourFavCallback){
        api.findHistTour(user_id)
            .enqueue(object : Callback <List<TourFav>> {
                override fun onResponse(
                    call: Call<List<TourFav>>,
                    response: Response<List<TourFav>>
                ) {
                    if (response.isSuccessful) {
                        callback.onSuccess(response.body()!!)
                    } else {
                        callback.onError()
                    }
                }

                override fun onFailure(call: Call<List<TourFav>>, t: Throwable) {
                    callback.onFailure(t)
                    Log.d("MyLog", "Ошибка при выполнении запроса: ${t.message}")
                }
            })
    }

    fun orderTour(user_id: String,tour_id: Int, callback: ConfCallback){
        api.orderTour(user_id,tour_id)
            .enqueue(object : Callback <ConfirmResponse> {
                override fun onResponse(
                    call: Call<ConfirmResponse>,
                    response: Response<ConfirmResponse>
                ) {
                    if (response.isSuccessful) {
                        callback.onSuccess(response.body()!!)
                    } else {
                        callback.onError()
                    }
                }

                override fun onFailure(call: Call<ConfirmResponse>, t: Throwable) {
                    callback.onFailure(t)
                    Log.d("MyLog", "Ошибка при выполнении запроса: ${t.message}")
                }
            })
    }

    fun updateHist(tour_id: Int, user_id: String, callback: UpdateFaveCallback){
        api.updateHist(tour_id,user_id)
            .enqueue(object : Callback <Void> {
                override fun onResponse(
                    call: Call<Void>,
                    response: Response<Void>
                ) {
                    if (response.isSuccessful) {
                        callback.onSuccess()
                    } else {
                        callback.onError()
                    }
                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    callback.onFailure(t)
                    Log.d("MyLog", "Ошибка при выполнении запроса: ${t.message}")
                }
            })
    }
    fun getDocks(user_id: String, callback: DockCallback){
        api.getDocks(user_id)
            .enqueue(object : Callback <DocksInfo> {
                override fun onResponse(
                    call: Call<DocksInfo>,
                    response: Response<DocksInfo>
                ) {
                    if (response.isSuccessful) {
                        Log.d("MyLog", "успешно ${response.body()!!.passport.date_of_given}")
                        callback.onSuccess(response.body()!!)
                    } else {
                        callback.onError()
                    }
                }

                override fun onFailure(call: Call<DocksInfo>, t: Throwable) {
                    callback.onFailure(t)
                    Log.d("MyLog", "Ошибка при выполнении запроса: ${t.message}")
                }
            })
    }
    fun uploadDocks(user_id: String, fullname:String,sex:String,
                    citizenship:String,serial:String,number:String,
                    registration:String,date_of_birth:String,date_of_given:String,
                    who_gave:String, callback: UpdateFaveCallback){
        api.uploadDocks(user_id, DockRequest(fullname,sex,citizenship,serial,number,registration,date_of_birth,date_of_given,who_gave))
            .enqueue(object : Callback <Void> {
                override fun onResponse(
                    call: Call<Void>,
                    response: Response<Void>
                ) {
                    if (response.isSuccessful) {
                        callback.onSuccess()
                    } else {
                        callback.onError()
                    }
                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    callback.onFailure(t)
                    Log.d("MyLog", "Ошибка при выполнении запроса: ${t.message}")
                }
            })
    }


}