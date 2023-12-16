package network_api

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.travel_agency.models.LoginRequest
import com.example.travel_agency.models.RegRequest
import com.example.travel_agency.models.Tour
import com.example.travel_agency.models.Tours
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Path


class InitAPI(){
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
        fun onSuccess(response: Any)
        fun onError()
        fun onFailure(error: Throwable)
    }
    interface RegCallback {
        fun onSuccess(response: Any)
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

    fun loginUser(login: String, password: String, callback: LoginCallback) {

        api.loginUser(LoginRequest(login, password))
            .enqueue(object : Callback<Void> {
                override fun onResponse(
                    call: Call<Void>,
                    response: Response<Void>
                ) {
                    if (response.isSuccessful) {
                        callback.onSuccess(response)
                    } else {
                        callback.onError()
                    }
                }


                override fun onFailure(call: Call<Void>, t: Throwable) {
                    callback.onFailure(t)
                    Log.d("MyLog", "Ошибка при выполнении запроса: ${t.message}")
                    callback.onFailure(t)
//                    Log.d("MyLog", "login: ${t.message}")
                }

            })
    }
    fun regUser(login: String, email: String, password: String, password_confirm: String, callback: RegCallback){
        api.regUser(RegRequest(login,email,password,password_confirm))
            .enqueue(object : Callback<Void> {
                override fun onResponse(
                    call: Call<Void>,
                    response: Response<Void>
                ) {
                    if (response.isSuccessful) {
                        callback.onSuccess(response)
                    } else {
                        callback.onError()
                    }
                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
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


}