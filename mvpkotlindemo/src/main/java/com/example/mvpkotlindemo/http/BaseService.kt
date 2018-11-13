package com.example.mvpkotlindemo.http

import com.example.mvpkotlindemo.bean.AndroidBean

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path


/**
 * Author: taoyongxiang
 * Date: 2018/9/4
 * Project: KotlinDemo
 * Desc: 网络请求的服务接口
 */

interface BaseService {

    /**
     * 根据category获取Android、ios等数据
     * category：类型
     * count：分页的一页数据
     * page：第几页
     */
    @GET("search/query/listview/category/{category}/count/{count}/page/{page}")
    fun getCategoryData(@Path("category") category: String,
                        @Path("count") count: Int,
                        @Path("page") page: Int): Observable<AndroidBean>

}