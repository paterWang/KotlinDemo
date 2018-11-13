package com.example.mvpkotlindemo.http

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * private  constructor() 私有构造
 */
class RetrofitUtils private constructor() {
    private  val okHttpClient :OkHttpClient =OkHttpUtil.mInstence.getHttpClient()!!
    private var retrofit: Retrofit? = null
    //静态方法（companion object）修饰静态方法
    companion object {
        val mInstance: RetrofitUtils by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
            RetrofitUtils()
        }

    }

    private  fun  getRetrofit():Retrofit?{
        if(null==retrofit){
            retrofit =Retrofit.Builder()
                    .baseUrl("https://gank.io/api/")
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build()
        }
        return retrofit

    }

    fun  getService() :BaseService{
        return RetrofitUtils.mInstance.getRetrofit()!!.create(BaseService::class.java)
    }
}