package com.itpln.uts_moprog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import com.google.android.material.textfield.TextInputEditText

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val etNama = findViewById<TextInputEditText>(R.id.etNama)
        val etNim = findViewById<TextInputEditText>(R.id.etNim)
        val etPassword = findViewById<TextInputEditText>(R.id.etPassword)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)

        btnSubmit.setOnClickListener {
            val nama = etNama.text.toString().trim()
            val nim = etNim.text.toString().trim()

            if (nama.isEmpty() || nim.isEmpty() || etPassword.text.isNullOrEmpty()) {
                AlertDialog.Builder(this)
                    .setTitle("Gagal")
                    .setMessage("Semua inputan harus diisi dulu!")
                    .setPositiveButton("OK", null)
                    .show()
                return@setOnClickListener
            }

            // pop up sesuai soal
            AlertDialog.Builder(this)
                .setTitle("Berhasil")
                .setMessage("Selamat $nama, Anda berhasil Login")
                .setPositiveButton("Lanjut") { _, _ ->
                    // pindah ke halaman hasil login sambil bawa nama & nim
                    val intent = Intent(this, HasilLoginActivity::class.java)
                    intent.putExtra("extra_nama", nama)
                    intent.putExtra("extra_nim", nim)
                    startActivity(intent)
                }
                .setCancelable(false)
                .show()
        }
    }
}
