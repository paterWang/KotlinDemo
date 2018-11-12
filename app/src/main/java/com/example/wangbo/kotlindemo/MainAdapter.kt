package com.example.wangbo.kotlindemo

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_main.view.*

/**
 * Created by wangbo on 2018/8/2.
 */
class MainAdapter(var context: Context, val item: List<String>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount(): Int {
        return item.size;

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        var inflate = LayoutInflater.from(context).inflate(R.layout.item_main, parent, false)
        if (viewType == 1) {

            return MainViewHolder(inflate)
        }
        return MainViewHolder(inflate)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {

        if (holder is MainViewHolder) {
            holder.bind(item.get(position))
        }
    }

    override fun getItemViewType(position: Int): Int {
        return 1
    }

    class MainViewHolder(val inflater: View) : RecyclerView.ViewHolder(inflater) {
        fun bind(str: String) {
            inflater.main_tv.text = str
        }
    }

}