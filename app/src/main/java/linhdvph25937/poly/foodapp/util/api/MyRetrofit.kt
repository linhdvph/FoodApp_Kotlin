package linhdvph25937.poly.foodapp.util.api

import linhdvph25937.poly.foodapp.model.Users
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface MyRetrofit {
    val retrofit: MyRetrofit
        get() = Retrofit.Builder()
            .baseUrl("http://192.168.0.11:3000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MyRetrofit::class.java)

    @FormUrlEncoded
    @POST("api/users/sign-in")
    fun signIn(@Field("phoneNumber") phoneNumber:String, @Field("passwd") passwd: String): Call<Users>
}