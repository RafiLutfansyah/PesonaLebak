package id.sitirohtiani.pesonalebak.views.rating

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import id.sitirohtiani.pesonalebak.R
import id.sitirohtiani.pesonalebak.base.RatingView
import id.sitirohtiani.pesonalebak.model.Rating
import kotlinx.android.synthetic.main.activity_rating.*

class RatingActivity : AppCompatActivity(), RatingView {
    private var presenter: RatingPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rating)

        initPresenter()
        onAttachView()

        buttonRating.isEnabled = false
        ratingBar.isEnabled = false

        Toast.makeText(this, intent.getStringExtra("idWisata"), Toast.LENGTH_SHORT).show()

        presenter!!.checkRating(intent.getStringExtra("idWisata").toInt())

        buttonRating.setOnClickListener {
            if (ratingBar.rating.toString() == "0.0") {
                Toast.makeText(this, "Masukan Rating!", Toast.LENGTH_SHORT).show()
            } else {
                presenter!!.setRating(intent.getStringExtra("idWisata").toInt(), ratingBar.rating)
            }
        }
    }

    override fun onResponse(string: String) {
        ratingBar.rating = string.toFloat()
        buttonRating.isEnabled = false
        ratingBar.isEnabled = false

        Toast.makeText(this, string, Toast.LENGTH_SHORT).show()
    }

    override fun onFailure(t: String) {
        buttonRating.isEnabled = true
        ratingBar.isEnabled = true
        Toast.makeText(this, t, Toast.LENGTH_SHORT).show()
    }

    override fun onSuccess(t: String) {
        buttonRating.isEnabled = false
        ratingBar.isEnabled = false


        Toast.makeText(this, t, Toast.LENGTH_SHORT).show()
    }

    override fun onFailed(t: String) {
        buttonRating.isEnabled = false
        ratingBar.isEnabled = false


        Toast.makeText(this, t, Toast.LENGTH_SHORT).show()
    }

    private fun initPresenter() {
        presenter = RatingPresenter(this)
    }

    override fun onAttachView() {
        presenter!!.onAttach(this)
    }

    override fun onDetachView() {
        presenter!!.onDetach()
    }

    override fun onDestroy() {
        onDetachView()
        super.onDestroy()
    }
}
