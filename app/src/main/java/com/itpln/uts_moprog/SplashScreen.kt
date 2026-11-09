package com.itpln.uts_moprog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.itpln.uts_moprog.MainActivity
import com.itpln.uts_moprog.R

class SplashScreen : AppCompatActivity() {
    private val handler = Handler(Looper.getMainLooper())

    // Pekerjaan yang dijalankan setelah 3 detik
    private val pindahHalaman = Runnable {
        startActivity(Intent(this, MainActivity::class.java))
        finish()   // tutup splash agar tombol Back di halaman utama tidak kembali ke splash
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        handler.postDelayed(pindahHalaman, 3000)   // 3000 milidetik = 3 detik
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacks(pindahHalaman)
    }
}
