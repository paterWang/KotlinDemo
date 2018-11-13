package com.example.mvpkotlindemo.http

import com.facebook.common.internal.AndroidPredicates
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.*
import javax.security.auth.callback.Callback

class HttpUtils private constructor() {

    companion object {
        //lazy   接受一个lambda  并且返回一个lazy得实例函数
        val mInstance: HttpUtils by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            HttpUtils()
        }
    }

    //rxjava 生成一个请求方法
    fun <T> requst(observable: Observable<T>, callback: OnHttpResponse<T>) {
        observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<T> {
                    override fun onComplete() {

                    }

                    override fun onSubscribe(d: Disposable?) {
                    }

                    override fun onNext(value: T) {
                        callback.onSuccess(value)
                    }

                    override fun onError(e: Throwable?) {
                        if (e!=null){
                            callback.onFailed(e,e.message!!)
                        }
                    }

                })
    }

}