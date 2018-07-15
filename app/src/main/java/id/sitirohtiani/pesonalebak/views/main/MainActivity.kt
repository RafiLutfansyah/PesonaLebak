package id.sitirohtiani.pesonalebak.views.main

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import id.sitirohtiani.pesonalebak.R
import id.sitirohtiani.pesonalebak.base.MainView
import id.sitirohtiani.pesonalebak.views.login.LoginActivity
import kotlinx.android.synthetic.main.activity_main.*
import android.support.v7.app.AlertDialog
import com.synnapps.carouselview.ImageListener
import id.sitirohtiani.pesonalebak.views.destinasi.DestinasiActivity


class MainActivity : AppCompatActivity(), MainView {
    var presenter: MainPresenter? = null

    var sampleImages = intArrayOf(R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher)

    private var imageListener: ImageListener = ImageListener { position, imageView -> imageView.setImageResource(sampleImages[position]) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initPresenter()
        onAttachView()

        presenter!!.cekUser()
        buttons()

        carouselView!!.pageCount = sampleImages.size
        carouselView!!.setImageListener(imageListener)
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
