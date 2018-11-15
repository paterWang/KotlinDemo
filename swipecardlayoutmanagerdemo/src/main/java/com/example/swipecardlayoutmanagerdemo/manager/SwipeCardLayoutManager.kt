package com.example.swipecardlayoutmanagerdemo.manager

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

class SwipeCardLayoutManager : RecyclerView.LayoutManager() {
    override fun generateDefaultLayoutParams(): RecyclerView.LayoutParams {
        return RecyclerView.LayoutParams(RecyclerView.LayoutParams.WRAP_CONTENT, RecyclerView.LayoutParams.WRAP_CONTENT)
    }

    override fun onLayoutChildren(recycler: RecyclerView.Recycler?, state: RecyclerView.State?) {

        //将view放入回收站
        detachAndScrapAttachedViews(recycler)
        //设置开始遍历的position
        var initPosition: Int
        if (CardConfig.MAX_SHOW_COUNT > itemCount) {
            initPosition = 0
        } else {
            initPosition = itemCount - CardConfig.MAX_SHOW_COUNT
        }
        //循环遍历摆放子view

        for (position in initPosition..itemCount - 1) {
            //取回回收的view
            val view = recycler!!.getViewForPosition(position)
            //添加到manager里
            addView(view)
            //测量view
            measureChild(view, 0, 0)
            //摆放控件


            //获取控件的高和宽
            var decorateWidth  = getDecoratedMeasuredWidth(view)
            var decorteHight = getDecoratedMeasuredHeight(view)
            var left =(width-decorateWidth)/2
            var top = (height-decorteHight)/2
            layoutDecorated(view,left,top,left+decorateWidth,top+decorteHight)
            val  level =itemCount-position-1
            if(level>0){
                view.scaleX=1f-CardConfig.SCALE*level
                view.scaleY=1f -CardConfig.SCALE*level
                if(level<CardConfig.MAX_SHOW_COUNT-1){
                    view.translationY=CardConfig.TRAN_Y_GAP*level.toFloat()
                }else{
                    view.translationY=CardConfig.TRAN_Y_GAP*(level-1).toFloat()
                }

            }
        }

    }
}