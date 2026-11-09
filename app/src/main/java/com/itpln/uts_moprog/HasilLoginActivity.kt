package com.itpln.uts_moprog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class HasilLoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hasil_login)

        val nama = intent.getStringExtra("extra_nama")
        val nim = intent.getStringExtra("extra_nim")

        findViewById<TextView>(R.id.tvNama).text = "Nama : $nama"
        findViewById<TextView>(R.id.tvNim).text = "NIM : $nim"

        // tombol back balik ke halaman utama
        findViewById<ImageView>(R.id.btnBack).setOnClickListener {
            Intent(this, MainActivity::class.java).also {
                startActivity(it)
                finish()
            }
        }

        // intent implicit buat share ke aplikasi lain
        findViewById<Button>(R.id.btnShare).setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, "Halo, saya $nama dengan NIM $nim berhasil login di Apps-Perpustakaan!")
            startActivity(Intent.createChooser(shareIntent, "Bagikan lewat"))
        }
    }
}
