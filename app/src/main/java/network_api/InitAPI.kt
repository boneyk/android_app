package network_api

import android.util.Log
import com.example.travel_agency.models.LoginRequest
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


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
}