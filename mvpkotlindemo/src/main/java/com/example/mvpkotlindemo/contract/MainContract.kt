package com.example.mvpkotlindemo.contract

import android.graphics.pdf.PdfDocument
import com.example.mvpkotlindemo.bean.AndroidBean
import com.example.mvpkotlindemo.view.IBaseView

interface  IMainModel{
    //获取mainactivity 网络请求数据
    fun getAndroidData(category: String,page: Int,listener:OnGetAndroidDataListener  )
    interface OnGetAndroidDataListener{
        fun onGetAndroidDataFinised(bean:AndroidBean?)
    }
}

interface IMainView :IBaseView{
    fun showAndroidData(bean: AndroidBean)
    fun showErrorMsg(msg:String ="亲  网络出问题了吗")
}