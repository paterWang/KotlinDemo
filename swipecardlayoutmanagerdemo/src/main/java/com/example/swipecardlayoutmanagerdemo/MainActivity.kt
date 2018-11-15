package com.example.swipecardlayoutmanagerdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import com.example.laer.recyclerviewmanager.entity.User
import com.example.laer.recyclerviewmanager.manager.LCallBack
import com.example.swipecardlayoutmanagerdemo.adapter.SwipeAdapter
import com.example.swipecardlayoutmanagerdemo.manager.CardConfig
import com.example.swipecardlayoutmanagerdemo.manager.SwipeCardLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        CardConfig.initConfug(this)
        rc_swip.layoutManager = SwipeCardLayoutManager()
        val datas = User.init()
        var swipeAdapter = SwipeAdapter(datas, this)
        rc_swip.adapter = swipeAdapter
        var helper: ItemTouchHelper = ItemTouchHelper(LCallBack(swipeAdapter, datas))
        helper.attachToRecyclerView(rc_swip)
    }
}
