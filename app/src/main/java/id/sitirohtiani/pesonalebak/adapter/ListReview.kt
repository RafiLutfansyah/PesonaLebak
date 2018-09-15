package id.sitirohtiani.pesonalebak.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.glide.slider.library.svg.GlideApp
import id.sitirohtiani.pesonalebak.R
import id.sitirohtiani.pesonalebak.model.Review
import kotlinx.android.synthetic.main.list_review.view.*
import com.bumptech.glide.load.engine.DiskCacheStrategy

class ListReview(val reviews: List<Review>) : RecyclerView.Adapter<ListReview.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindItems(review: Review) = with(itemView) {
            GlideApp.with(context)
                    .asBitmap()
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                    .load(review.url_foto)
                    .into(itemView.imageView)

            tvNama.text = review.nama
            tvReview.text = review.review
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_review, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(reviews.get(position))
    }

    override fun getItemCount(): Int {
        return reviews.size
    }
}