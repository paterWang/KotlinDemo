package com.example.swipecardlayoutmanagerdemo.manager

import android.content.Context
import android.util.TypedValue

object CardConfig {
    //最大显示的卡片数量
    var MAX_SHOW_COUNT: Int =0
    //每一级Scale相差0.05f，translationY相差7dp左右
    var SCALE :Float =0.toFloat()
    var TRAN_Y_GAP:Int=0
fun initConfug(context:Context){
    MAX_SHOW_COUNT=4
    SCALE=0.05f
    TRAN_Y_GAP =TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,15f,context.resources.displayMetrics).toInt()
}

}