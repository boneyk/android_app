package network_api

import android.util.Log
import com.example.travel_agency.models.ConfRequest
import com.example.travel_agency.models.ConfirmResponse
import com.example.travel_agency.models.DockRequest
import com.example.travel_agency.models.DocksInfo
import com.example.travel_agency.models.Docksmall
import com.example.travel_agency.models.HistElement
import com.example.travel_agency.models.LoginRequest
import com.example.travel_agency.models.LoginResponse
import com.example.travel_agency.models.Pass
import com.example.travel_agency.models.Passport
import com.example.travel_agency.models.PersInfo
import com.example.travel_agency.models.Person
import com.example.travel_agency.models.ProfRequest
import com.example.travel_agency.models.RegRequest
import com.example.travel_agency.models.Tour
import com.example.travel_agency.models.TourFav
import com.example.travel_agency.models.TourResponse
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
        fun onSuccess(response: TourResponse)
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
        fun onSuccess(response: LoginResponse)
        fun onError()
        fun onFailure(error: Throwable)
    }
    interface ConfCallback {
        fun onSuccess(response: ConfirmResponse)
        fun onError()
        fun onFailure(error: Throwable)
    }
    interface DockCallback {
        fun onSuccess(response: List<Person>)
        fun onError()
        fun onFailure(error: Throwable)
    }
    interface UpdateDocksCallback {
        fun onSuccess()
        fun onError()
        fun onFailure(error: Throwable)
    }
    interface ConfTourCallback {
        fun onSuccess(response: Any)
        fun onError()
        fun onFailure(error: Throwable)
    }
    interface HistTourCallback {
        fun onSuccess(response: List<HistElement>)
        fun onError()
        fun onFailure(error: Throwable)
    }
    interface DockInfoCallback {
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
    fun findTourWithId(id: Int,user_id: String, callback: TourCallback){
        api.findTourWithId(id,user_id)
            .enqueue(object : Callback<TourResponse> {
                override fun onResponse(
                    call: Call<TourResponse>,
                    response: Response<TourResponse>
                ) {
                    if (response.isSuccessful) {
                        callback.onSuccess(response.body()!!)
                    } else {
                        callback.onError()
                    }
                }

                override fun onFailure(call: Call<TourResponse>, t: Throwable) {
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

    fun putUserInfo(user_id: String,login : String, email : String,password : String, callback: ProfCallback){
        api.putUserInfo(user_id, ProfRequest(login,email,password))
            .enqueue(object : Callback <LoginResponse> {
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
                }
            })
    }
    fun findHistTour(user_id: String, callback: HistTourCallback){
        api.findHistTour(user_id)
            .enqueue(object : Callback <List<HistElement>> {
                override fun onResponse(
                    call: Call<List<HistElement>>,
                    response: Response<List<HistElement>>
                ) {
                    if (response.isSuccessful) {
                        callback.onSuccess(response.body()!!)
                    } else {
                        callback.onError()
                    }
                }

                override fun onFailure(call: Call<List<HistElement>>, t: Throwable) {
                    callback.onFailure(t)
                    Log.d("MyLog", "Ошибка при выполнении запроса: ${t.message}")
                }
            })
    }

    fun orderTour(date_id: Int, tour_id: Int, user_id: String, selectedPeople: List<Person>, callback: ConfCallback) {
        api.orderTour(ConfRequest(date_id, tour_id, user_id, selectedPeople))
            .enqueue(object : Callback<ConfirmResponse> {
                override fun onResponse(call: Call<ConfirmResponse>, response: Response<ConfirmResponse>) {
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

    fun updateHist(date_id: Int, tour_id: Int, user_id: String, selectedPeople: List<Person>, callback: ConfTourCallback) {
        api.updateHist(ConfRequest(date_id, tour_id, user_id, selectedPeople))
            .enqueue(object : Callback<Any> {
                override fun onResponse(call: Call<Any>, response: Response<Any>) {
                    if (response.isSuccessful) {
                        callback.onSuccess(response.body()!!)
                    } else {
                        callback.onError()
                    }
                }

                override fun onFailure(call: Call<Any>, t: Throwable) {
                    callback.onFailure(t)
                    Log.d("MyLog", "Ошибка при выполнении запроса: ${t.message}")
                }
            })
    }

    fun getDocks(user_id: String, callback: DockCallback){
        api.getDocks(user_id)
            .enqueue(object : Callback <List<Person>> {
                override fun onResponse(
                    call: Call<List<Person>>,
                    response: Response<List<Person>>
                ) {
                    if (response.isSuccessful) {
                        callback.onSuccess(response.body()!!)
                    } else {
                        callback.onError()
                    }
                }

                override fun onFailure(call: Call<List<Person>>, t: Throwable) {
                    callback.onFailure(t)
                    Log.d("MyLog", "Ошибка при выполнении запроса: ${t.message}")
                }
            })
    }

    fun putPeop(user_id: String, callback: LoginCallback){
        api.putPeop(user_id)
            .enqueue(object : Callback <LoginResponse> {
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
                }
            })
    }
    fun uploadDocks(user_id: String, fullname: String,sex: String,
                    dob:String, citizenship:String,serial:String,
                    number:String,dog:String, wg:String,
                    registration:String, callback: UpdateDocksCallback){
        api.uploadDocks(user_id, Passport(fullname,sex,dob,citizenship,serial,number,dog, wg, registration))
            .enqueue(object : Callback <Void> {
                override fun onResponse(
                    call: Call<Void>,
                    response: Response<Void>
                ) {
                    if (response.isSuccessful) {
                        callback.onSuccess()
                    } else {
                        Log.e("MyLog", "Ошибка при выполнении запроса: ${callback.onError()}")
                        callback.onError()
                    }
                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    callback.onFailure(t)
                    Log.d("MyLog", "Ошибка при выполнении запроса: ${t.message}")
                }
            })
    }

    fun getDocksInfo(user_id: String, callback: DockInfoCallback){
        api.getDocksInfo(user_id)
            .enqueue(object : Callback <DocksInfo> {
                override fun onResponse(
                    call: Call<DocksInfo>,
                    response: Response<DocksInfo>
                ) {
                    if (response.isSuccessful) {
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
    fun setPersInfo(user_id: String, fullname: String,
                    phone_number:String, callback: UpdateDocksCallback){
        api.setPersInfo(user_id, Docksmall(fullname,phone_number))
            .enqueue(object : Callback <Void> {
                override fun onResponse(
                    call: Call<Void>,
                    response: Response<Void>
                ) {
                    if (response.isSuccessful) {
                        callback.onSuccess()
                    } else {
                        Log.e("MyLog", "Ошибка при выполнении запроса: ${callback.onError()}")
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