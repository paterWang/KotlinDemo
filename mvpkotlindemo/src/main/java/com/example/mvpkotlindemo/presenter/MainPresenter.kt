package com.example.mvpkotlindemo.presenter

import com.example.mvpkotlindemo.base.BasePresenter
import com.example.mvpkotlindemo.bean.AndroidBean
import com.example.mvpkotlindemo.contract.IMainModel
import com.example.mvpkotlindemo.contract.IMainView
import com.example.mvpkotlindemo.model.MainModel

class MainPresenter(mView: IMainView) : BasePresenter<IMainView>(), IMainModel.OnGetAndroidDataListener {

    private var mView: IMainView? = mView
    private var mModel: MainModel? = null


    init {
        mModel = MainModel()
    }

    fun getAndroidData(category: String, page: Int) {
        this.mView?.showLoading()
        this.mModel?.getAndroidData(category, page, this)
    }

    override fun onGetAndroidDataFinised(bean: AndroidBean?) {
        this.mView?.hideLoading()
        if (null != bean) {
            this.mView?.showAndroidData(bean)
            if (bean.error == "true") {
                this.mView?.showErrorMsg()
            }

        } else {
            this.mView?.showErrorMsg()
        }

    }
}