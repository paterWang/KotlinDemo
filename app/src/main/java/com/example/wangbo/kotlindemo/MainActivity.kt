package com.example.wangbo.kotlindemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var list = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bt_start.setOnClickListener {
            Toast.makeText(this, "tttt", Toast.LENGTH_SHORT).show()

        }
        list.add("sdsdsd")
        list.add("sdsdsd")
        list.add("sdsdsd")
        list.add("sdsdsd")

        ee.layoutManager = LinearLayoutManager(this)
        ee.adapter =MainAdapter(this,list)
        val items = listOf("张山","李四","王五")
        for (item in items.indices){
           Log.e("ceshi",item.toString())
        }

    }
}
