package com.example.swipecardlayoutmanagerdemo.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.laer.recyclerviewmanager.entity.User
import com.example.swipecardlayoutmanagerdemo.R

class SwipeAdapter constructor(list: ArrayList<User>, context: Context) : RecyclerView.Adapter<SwipeAdapter.SwipViewHolder>() {

    var context: Context? = context
    var list: ArrayList<User> = list

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SwipViewHolder {
        val item = LayoutInflater.from(context).inflate(R.layout.item_swip, parent, false)
        return SwipViewHolder(item)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: SwipViewHolder, position: Int) {
        holder!!.bindView(list.get(position))

    }


    inner class SwipViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var iv = itemView!!.findViewById<ImageView>(R.id.iv)
        var tvName = itemView!!.findViewById<TextView>(R.id.tvName)
        var tvPrecent = itemView!!.findViewById<TextView>(R.id.tvPrecent)
        fun bindView(user: User) {
            tvName.text = user.name
            tvPrecent.text = user.position.toString() + "/" + list.size
            Glide.with(context).load(user.imagePath).into(iv)
        }
    }

}