package com.mani.kotlinsample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout



class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val rclKotlin = findViewById(R.id.rclKotlin) as RecyclerView
        rclKotlin.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        val arrList = ArrayList<User>()

        arrList.add(User("Mani", "Arumpakkam"))
        arrList.add(User("Test", "Chennai"))
        arrList.add(User("Test1", "Chennai2"))
        val adapter = CustomAdapter(arrList,this@Main2Activity)
        rclKotlin.adapter=adapter
 
    }

    data class User(val name: String, val address: String)
}

