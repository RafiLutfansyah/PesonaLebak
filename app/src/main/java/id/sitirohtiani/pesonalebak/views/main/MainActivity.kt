package id.sitirohtiani.pesonalebak.views.main

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import id.sitirohtiani.pesonalebak.R
import id.sitirohtiani.pesonalebak.base.MainView
import id.sitirohtiani.pesonalebak.views.login.LoginActivity
import kotlinx.android.synthetic.main.activity_main.*
import android.support.v7.app.AlertDialog
import android.widget.Toast
import com.synnapps.carouselview.ImageListener
import id.sitirohtiani.pesonalebak.views.destinasi.DestinasiActivity
import java.util.*
import com.glide.slider.library.SliderLayout
import kotlin.collections.ArrayList
import com.bumptech.glide.load.resource.bitmap.TransformationUtils.centerCrop
import com.bumptech.glide.request.RequestOptions
import com.glide.slider.library.SliderTypes.BaseSliderView
import com.glide.slider.library.SliderTypes.TextSliderView
import id.sitirohtiani.pesonalebak.views.TentangActivity

class MainActivity : AppCompatActivity(), MainView {

    var presenter: MainPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initPresenter()
        onAttachView()

        presenter!!.cekUser()
        buttons()
    }

    override fun onShowMainCarousel(listUrl: java.util.ArrayList<String>, listName: java.util.ArrayList<String>) {
        val requestOptions = RequestOptions()
        requestOptions.centerCrop()

        for ((i, j) in listUrl.withIndex()) {
            val sliderView = TextSliderView(this)

            sliderView
                    .image("${resources.getString(R.string.base_url)}uploads/${listUrl[i]}")
                    .description(listName[i])
                    .setRequestOption(requestOptions)
                    .setBackgroundColor(Color.WHITE)
                    .setProgressBarVisible(true)
                    .setOnSliderClickListener {

                    }

            sliderView.bundle(Bundle())
            sliderView.bundle.putString("extra", listName[i])
            slider.addSlider(sliderView)
        }
    }

    private fun buttons() {
        buttonPariwisata.setOnClickListener {
            val intent = Intent(this, DestinasiActivity::class.java)
            intent.putExtra("destinasi", "Parawisata")
            startActivity(intent)
        }

        buttonKebudayaan.setOnClickListener {
            val intent = Intent(this, DestinasiActivity::class.java)
            intent.putExtra("destinasi", "Kebudayaan")
            startActivity(intent)
        }

        buttonTentang.setOnClickListener {
            startActivity(Intent(this, TentangActivity::class.java))
        }

        buttonLogout.setOnClickListener {
            showDialog()
        }
    }

    private fun showDialog() {
        AlertDialog.Builder(this)
                .setTitle("Keluar dari aplikasi?")
                .setMessage("Klik Ya untuk keluar!")
                .setIcon(R.mipmap.ic_launcher)
                .setCancelable(false)
                .setPositiveButton("Ya") { dialog, id ->
                    presenter!!.signOut()
                }
                .setNegativeButton("Tidak") { dialog, id ->
                    dialog.cancel()
                }
                .create()
                .show()
    }

    override fun onSignOut() {
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.signOut -> {
                presenter!!.signOut()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun initPresenter() {
        presenter = MainPresenter(this)
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
