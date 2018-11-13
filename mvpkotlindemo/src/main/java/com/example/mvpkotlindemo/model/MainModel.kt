package com.example.mvpkotlindemo.model

import android.widget.Toast
import com.example.mvpkotlindemo.bean.AndroidBean
import com.example.mvpkotlindemo.contract.IMainModel
import com.example.mvpkotlindemo.http.HttpUtils
import com.example.mvpkotlindemo.http.OnHttpResponse
import com.example.mvpkotlindemo.http.RetrofitUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainModel : IMainModel {
    override fun getAndroidData(category: String, page: Int, listener: IMainModel.OnGetAndroidDataListener) {
        val categoryData = RetrofitUtils.mInstance.getService().getCategoryData(category, 10, page)
        HttpUtils.mInstance.requst(categoryData,object : OnHttpResponse<AndroidBean> {
            override fun onFailed(t: Throwable, msg: String) {
                listener.onGetAndroidDataFinised(null)
            }

            override fun onSuccess(bean: AndroidBean) {
                listener.onGetAndroidDataFinised(bean)
            }

        })

    }
}