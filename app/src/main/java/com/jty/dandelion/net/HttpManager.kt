package com.jty.dandelion.net


import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.jty.dandelion.register.bean.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HttpManager {
    companion object {
        private val retrofit by lazy {
            Retrofit.Builder()
                .baseUrl("http://192.168.31.206:8080/DandelionServer_war_exploded/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        }
        private val service = retrofit.create(RequestService::class.java)


        fun registerUser(user: User, liveData: MutableLiveData<Result>) {
            service.registerUser(user).also {
                it.enqueue(object : Callback<Result> {
                    override fun onResponse(call: Call<Result>, response: Response<Result>) {
                     Log.d("response","code:${response.code()},message:${response.message()},body:${response.body()}")
                        if (response.isSuccessful) {
                            liveData.postValue(response.body())
                        } else {
                            liveData.postValue(Result(response.code(), null, response.message(), false))
                        }
                    }

                    override fun onFailure(call: Call<Result>?, t: Throwable?) {
                        liveData.postValue(Result(404, null, "服务器出现故障，正在抢修", false))
                    }

                })
            }
        }

        fun LoginUser(account: String, password: String, liveData: MutableLiveData<Result>) {
            service.LoginUser(account, password).apply {
                enqueue(object : Callback<Result> {
                    override fun onFailure(call: Call<Result>, t: Throwable) {
                        liveData.postValue(Result(404, null, "服务器出现故障，正在抢修", false))
                    }

                    override fun onResponse(call: Call<Result>, response: Response<Result>) {
                        if (response.isSuccessful) {
                            liveData.postValue(response.body())
                        } else {
                            liveData.postValue(Result(response.code(), null, response.message(), false))
                        }
                    }

                })
            }
        }
    }
}