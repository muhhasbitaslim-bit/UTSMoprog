package com.itpln.uts_moprog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnBuku = findViewById<Button>(R.id.btnBuku)
        val btnPeminjaman = findViewById<Button>(R.id.btnPeminjaman)

        // Explicit Intent ke halaman daftar buku
        btnBuku.setOnClickListener {
            startActivity(Intent(this, BukuActivity::class.java))
        }

        // Explicit Intent ke form peminjaman
        btnPeminjaman.setOnClickListener {
            startActivity(Intent(this, PeminjamanActivity::class.java))
        }
    }
}
