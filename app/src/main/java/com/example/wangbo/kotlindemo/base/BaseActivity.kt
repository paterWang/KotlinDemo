package com.example.wangbo.kotlindemo.base

import android.app.Activity
import android.os.Bundle

open class BaseActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    fun sendHttp(hashMap:HashMap<String,String> ) {


    }
}