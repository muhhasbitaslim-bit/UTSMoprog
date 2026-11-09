package com.itpln.uts_moprog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import android.widget.EditText
import android.widget.ImageButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast
import com.itpln.uts_moprog.R

class PeminjamanActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_peminjaman)

        val etNama = findViewById<EditText>(R.id.etNama)
        val rgAnggota = findViewById<RadioGroup>(R.id.rgAnggota)
        val spKategori = findViewById<Spinner>(R.id.spKategori)
        val datePicker = findViewById<DatePicker>(R.id.datePicker)
        val btnCeklis = findViewById<ImageButton>(R.id.btnCeklis)
        val btnBack = findViewById<ImageButton>(R.id.btnBack)
        val btnShare = findViewById<ImageButton>(R.id.btnShare)

        // Fungsi lokal: menyusun isi ringkasan dari data form saat ini
        fun buatRingkasan(): String {
            val nama = etNama.text.toString()
            val anggota = if (rgAnggota.checkedRadioButtonId == R.id.rbDosen) "Dosen" else "Mahasiswa"
            val kategori = spKategori.selectedItem.toString()
            val tanggal = "%02d/%02d/%d".format(
                datePicker.dayOfMonth,
                datePicker.month + 1,   // bulan pada DatePicker dihitung dari 0
                datePicker.year
            )
            return "Nama: $nama\n" +
                    "Anggota: $anggota\n" +
                    "Kategori: $kategori\n" +
                    "Tanggal: $tanggal"
        }

        // Tombol ceklis: tampilkan ringkasan lewat Toast
        btnCeklis.setOnClickListener {
            val nama = etNama.text.toString().trim()

            if (nama.isEmpty()) {
                etNama.error = "Nama wajib diisi"
                etNama.requestFocus()
                return@setOnClickListener
            }

            Toast.makeText(this, "Peminjaman Berhasil\n" + buatRingkasan(), Toast.LENGTH_LONG).show()
        }

        // Tombol share: Implicit Intent, bagikan ringkasan ke aplikasi lain
        btnShare.setOnClickListener {
            val share = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_SUBJECT, "Ringkasan Peminjaman Buku")
                putExtra(Intent.EXTRA_TEXT, "Ringkasan Peminjaman\n" + buatRingkasan())
            }
            startActivity(Intent.createChooser(share, "Share ringkasan"))
        }

        // Tombol back: kembali ke MainActivity
        btnBack.setOnClickListener {
            finish()
        }
    }
}
