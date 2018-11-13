package com.example.mvpkotlindemo.http

import com.parkingwang.okhttp3.LogInterceptor.LogInterceptor
import okhttp3.OkHttpClient

class OkHttpUtil private constructor(){
    //初始化 okhttpclient
    private  var okHttpClient :OkHttpClient? =null
    companion object {
        val mInstence :OkHttpUtil by  lazy(LazyThreadSafetyMode.SYNCHRONIZED){
            OkHttpUtil()
        }
    }

    fun getHttpClient(): OkHttpClient?{
        if(null ==okHttpClient){
            okHttpClient = OkHttpClient.Builder()
                    .build()
        }
        return  okHttpClient
    }
}