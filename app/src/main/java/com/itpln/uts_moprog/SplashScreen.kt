package com.itpln.uts_moprog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.animation.ObjectAnimator
import com.itpln.uts_moprog.MainActivity
import com.itpln.uts_moprog.R
import android.widget.ProgressBar

class SplashScreen : AppCompatActivity() {
    private val handler = Handler(Looper.getMainLooper())

    // Pekerjaan yang dijalankan setelah 5 detik
    private val pindahHalaman = Runnable {
        startActivity(Intent(this, MainActivity::class.java))
        finish()   // tutup splash agar tombol Back di halaman utama tidak kembali ke splash
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        // progress bar jalan 5 detik juga biar sinkron
        val pb = findViewById<ProgressBar>(R.id.pbSplash)
        val anim = ObjectAnimator.ofInt(pb, "progress", 0, 100)
        anim.duration = 5000
        anim.start()

        handler.postDelayed(pindahHalaman, 5000)   // 5000 milidetik = 5 detik
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacks(pindahHalaman)
    }
}
