package id.sitirohtiani.pesonalebak.adapter

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.glide.slider.library.svg.GlideApp
import id.sitirohtiani.pesonalebak.R
import id.sitirohtiani.pesonalebak.model.Wisata
import id.sitirohtiani.pesonalebak.views.detail.DetailActivity
import kotlinx.android.synthetic.main.list_wisata.view.*
import java.util.*
import com.bumptech.glide.load.engine.DiskCacheStrategy

class ListWisata(val wisatas: List<Wisata>) : RecyclerView.Adapter<ListWisata.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindItems(wisata: Wisata) = with(itemView) {

            val urlFoto = wisata.urlFoto.split(" ")
            Collections.shuffle(urlFoto)

            GlideApp.with(context)
                    .asBitmap()
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                    .load("${resources.getString(R.string.base_url)}uploads/${urlFoto[0]}")
                    .into(itemView.imageView)

            textNama.text = "${wisata.nama}"
            textAlamat.text = wisata.alamat

            itemView.setOnClickListener {
                val intent = Intent(context, DetailActivity::class.java)
                intent.putExtra("id", wisata.id.toString())
                intent.putExtra("nama", wisata.nama)
                intent.putExtra("keterangan", wisata.keterangan)
                intent.putExtra("urlFoto", wisata.urlFoto)
                intent.putExtra("alamat", wisata.alamat)
                intent.putExtra("koordinat", wisata.koordinat)
                context.startActivity(intent)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_wisata, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(wisatas.get(position))
    }

    override fun getItemCount(): Int {
        return wisatas.size
    }
}