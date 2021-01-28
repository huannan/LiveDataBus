package com.nan.livedatabus

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun send(view: View) {
        // 发送事件
        LiveDataBus.post("key", 1)
    }

    fun jump(view: View) {
        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)
    }

}