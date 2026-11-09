package com.itpln.uts_moprog

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.itpln.uts_moprog.R

class BukuAdapter(
    private val data: List<Buku>
) : RecyclerView.Adapter<BukuAdapter.BukuViewHolder>() {

    class BukuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivSampul: ImageView = itemView.findViewById(R.id.ivSampul)
        val tvJudul: TextView = itemView.findViewById(R.id.tvJudul)
        val tvPenulis: TextView = itemView.findViewById(R.id.tvPenulis)
        val tvStatus: TextView = itemView.findViewById(R.id.tvStatus)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BukuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_buku, parent, false)
        return BukuViewHolder(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: BukuViewHolder, position: Int) {
        val buku = data[position]

        holder.ivSampul.setImageResource(buku.sampul)
        holder.tvJudul.text = buku.judul
        holder.tvPenulis.text = buku.penulis
        holder.tvStatus.text = buku.status   // teks status diambil langsung dari data


    }
}
