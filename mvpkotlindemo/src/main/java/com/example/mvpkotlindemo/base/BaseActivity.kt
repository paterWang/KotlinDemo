package com.example.wangbo.kotlindemo.base

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.mvpkotlindemo.base.BasePresenter

abstract class BaseActivity<V,T: BasePresenter<V>> : AppCompatActivity()  {
    private var presenter:T?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        presenter=getPresenter()
        presenter?.attachView(this as V)
        initView()
        initData()
    }

    abstract fun initData()

    abstract fun initView()

    abstract fun getPresenter(): T?

    abstract fun getLayoutId(): Int

    fun sendHttp(hashMap:HashMap<String,String> ) {

    }
}