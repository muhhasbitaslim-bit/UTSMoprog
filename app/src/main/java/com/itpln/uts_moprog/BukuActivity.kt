package com.itpln.uts_moprog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.itpln.uts_moprog.R

class BukuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buku)

        val rvBuku = findViewById<RecyclerView>(R.id.rvBuku)

        // LayoutManager: daftar satu kolom, vertikal
        rvBuku.layoutManager = LinearLayoutManager(this)

        // Adapter: penghubung antara data (BukuData.daftar) dan RecyclerView
        rvBuku.adapter = BukuAdapter(BukuData.daftar)

    }
}
