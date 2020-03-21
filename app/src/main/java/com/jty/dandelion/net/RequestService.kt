package com.jty.dandelion.net

import com.jty.dandelion.register.bean.User
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface RequestService {


    @POST("RegisterServlet")
    fun registerUser(@Body user: User) : Call<Result>

    @FormUrlEncoded
    @POST("LoginServlet")
    fun LoginUser(@Field("account") account: String, @Field("password") password: String) : Call<Result>
}