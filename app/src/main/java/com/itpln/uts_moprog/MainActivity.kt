package com.itpln.uts_moprog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val btnList = findViewById<Button>(R.id.btnList)

        // Explicit Intent ke halaman login
        btnLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        // Explicit Intent ke halaman daftar buku (recycler view)
        btnList.setOnClickListener {
            startActivity(Intent(this, BukuActivity::class.java))
        }
    }
}
