package com.example.mvpkotlindemo.http

interface OnHttpResponse<T> {
    fun onSuccess(bean: T)
    fun onFailed(t: Throwable, msg: String)
}