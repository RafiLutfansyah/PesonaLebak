package id.sitirohtiani.pesonalebak.views.destinasi

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import id.sitirohtiani.pesonalebak.R
import id.sitirohtiani.pesonalebak.base.DestinasiView
import id.sitirohtiani.pesonalebak.views.main.DestinasiPresenter

class DestinasiActivity : AppCompatActivity(), DestinasiView {

    var presenter: DestinasiPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Toast.makeText(this, intent.getStringExtra("destinasi"), Toast.LENGTH_SHORT).show()

        if (intent.getStringExtra("destinasi") == "Parawisata") {
            setContentView(R.layout.activity_destinasi_parawisata)
        } else if (intent.getStringExtra("destinasi") == "Kebudayaan") {
            setContentView(R.layout.activity_destinasi_kebudayaan)
        }

        initPresenter()
        onAttachView()
    }

    private fun initPresenter() {
        presenter = DestinasiPresenter(this)
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
