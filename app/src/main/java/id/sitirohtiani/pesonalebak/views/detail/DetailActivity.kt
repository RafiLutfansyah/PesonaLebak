package id.sitirohtiani.pesonalebak.views.detail

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import id.sitirohtiani.pesonalebak.R
import kotlinx.android.synthetic.main.activity_detail.*
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.widget.Toast
import com.bumptech.glide.request.RequestOptions
import com.glide.slider.library.SliderTypes.TextSliderView
import id.sitirohtiani.pesonalebak.views.rating.RatingActivity
import id.sitirohtiani.pesonalebak.views.review.ReviewActivity
import java.util.*

class DetailActivity : AppCompatActivity(), DetailView {
    var presenter: DetailPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        initPresenter()
        onAttachView()

        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.title = intent.getStringExtra("nama")

        carousel()

        Toast.makeText(this, intent.getStringExtra("id"), Toast.LENGTH_SHORT).show()

        buttons(intent.getStringExtra("id"))

        textKeterangan.text = intent.getStringExtra("keterangan")
        textAlamat.text = intent.getStringExtra("alamat")

        presenter!!.getRating(intent.getStringExtra("id").toInt())
    }

    private fun carousel() {
        val urlFoto = intent.getStringExtra("urlFoto").split(" ")
        Collections.shuffle(urlFoto)

        val requestOptions = RequestOptions()
        requestOptions.centerCrop()

        for ((i, j) in urlFoto.withIndex()) {
            val sliderView = TextSliderView(this)

            sliderView
                    .image("${resources.getString(R.string.base_url)}uploads/$j")
                    .description(j)
                    .setRequestOption(requestOptions)
                    .setBackgroundColor(Color.WHITE)
                    .setProgressBarVisible(true)
                    .setOnSliderClickListener {

                    }

            sliderView.bundle(Bundle())
            sliderView.bundle.putString("extra", j)
            slider.addSlider(sliderView)
        }
    }

    private fun buttons(id: String) {
        buttonMaps.setOnClickListener {
            val url = intent.getStringExtra("koordinat")
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }

        buttonRating.setOnClickListener {
            val intent = Intent(this, RatingActivity::class.java)
            Toast.makeText(this, id.toString(), Toast.LENGTH_SHORT).show()
            intent.putExtra("idWisata", id)
            startActivity(intent)
        }

        buttonReview.setOnClickListener {
            val intent = Intent(this, ReviewActivity::class.java)
            Toast.makeText(this, id.toString(), Toast.LENGTH_SHORT).show()
            intent.putExtra("idWisata", id)
            startActivity(intent)
        }
    }

    override fun onResponseGetRating(rating: Int) {
        buttonRating.text = rating.toString()
    }

    override fun onFailure(t: String) {
        Toast.makeText(this, t, Toast.LENGTH_SHORT).show()
    }

    private fun initPresenter() {
        presenter = DetailPresenter(this)
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
