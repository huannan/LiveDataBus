package com.nan.livedatabus

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        /**
         * 非黏性接收
         */
        LiveDataBus.with("event_name", Int::class.java)
                .observe(this) {
                    Toast.makeText(this, "normal: $it", Toast.LENGTH_SHORT).show()
                }

        /**
         * 黏性接收
         */
        LiveDataBus.with("event_name", Int::class.java)
                .observe(this, true) {
                    Toast.makeText(this, "sticky: $it", Toast.LENGTH_SHORT).show()
                }
    }
}