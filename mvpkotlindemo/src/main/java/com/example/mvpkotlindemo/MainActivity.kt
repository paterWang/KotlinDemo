package com.example.mvpkotlindemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.mvpkotlindemo.bean.AndroidBean
import com.example.mvpkotlindemo.contract.IMainModel
import com.example.mvpkotlindemo.contract.IMainView
import com.example.mvpkotlindemo.http.HttpUtils
import com.example.mvpkotlindemo.http.OnHttpResponse
import com.example.mvpkotlindemo.http.RetrofitUtils
import com.example.mvpkotlindemo.presenter.MainPresenter
import com.example.wangbo.kotlindemo.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<IMainView, MainPresenter>(), IMainView {
    private var mainPresenter: MainPresenter? = null

    override fun showAndroidData(bean: AndroidBean) {
        date11.text = bean.results.toString()
    }

    override fun showErrorMsg(msg: String) {
        Toast.makeText(this@MainActivity, msg, Toast.LENGTH_SHORT).show()
    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun initData() {
        mainPresenter?.getAndroidData("android", 1)
    }

    override fun initView() {

    }

    override fun getPresenter(): MainPresenter? {
        mainPresenter = MainPresenter(this)
        return mainPresenter
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }


}
