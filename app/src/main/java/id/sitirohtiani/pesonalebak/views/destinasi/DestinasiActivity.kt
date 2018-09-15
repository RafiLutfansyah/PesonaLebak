package id.sitirohtiani.pesonalebak.views.destinasi

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import id.sitirohtiani.pesonalebak.R
import id.sitirohtiani.pesonalebak.base.DestinasiView
import id.sitirohtiani.pesonalebak.views.main.DestinasiPresenter
import id.sitirohtiani.pesonalebak.views.objekwisata.ObjekWisataActivity
import kotlinx.android.synthetic.main.activity_destinasi_kebudayaan.*
import kotlinx.android.synthetic.main.activity_destinasi_parawisata.*

class DestinasiActivity : AppCompatActivity(), DestinasiView {

    var presenter: DestinasiPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Toast.makeText(this, intent.getStringExtra("destinasi"), Toast.LENGTH_SHORT).show()

        if (intent.getStringExtra("destinasi") == "Parawisata") {
            setContentView(R.layout.activity_destinasi_parawisata)

            buttonAlam.setOnClickListener {
                val intent = Intent(this, ObjekWisataActivity::class.java)
                intent.putExtra("destinasi", "pariwisata")
                intent.putExtra("wisata", "wisata alam")
                startActivity(intent)
            }
            buttonBuatan.setOnClickListener {
                val intent = Intent(this, ObjekWisataActivity::class.java)
                intent.putExtra("destinasi", "pariwisata")
                intent.putExtra("wisata", "wisata buatan")
                startActivity(intent)
            }
            buttonBahari.setOnClickListener {
                val intent = Intent(this, ObjekWisataActivity::class.java)
                intent.putExtra("destinasi", "pariwisata")
                intent.putExtra("wisata", "wisata bahari")
                startActivity(intent)
            }
            buttonReligi.setOnClickListener {
                val intent = Intent(this, ObjekWisataActivity::class.java)
                intent.putExtra("destinasi", "pariwisata")
                intent.putExtra("wisata", "wisata religi")
                startActivity(intent)
            }
        } else if (intent.getStringExtra("destinasi") == "Kebudayaan") {
            setContentView(R.layout.activity_destinasi_kebudayaan)

            buttonSukuAdat.setOnClickListener {
                val intent = Intent(this, ObjekWisataActivity::class.java)
                intent.putExtra("destinasi", "kebudayaan")
                intent.putExtra("wisata", "masyarakat adat")
                startActivity(intent)
            }
            buttonKesenian.setOnClickListener {
                val intent = Intent(this, ObjekWisataActivity::class.java)
                intent.putExtra("destinasi", "kebudayaan")
                intent.putExtra("wisata", "kesenian")
                startActivity(intent)
            }
            buttonSitusPurbakala.setOnClickListener {
                val intent = Intent(this, ObjekWisataActivity::class.java)
                intent.putExtra("destinasi", "kebudayaan")
                intent.putExtra("wisata", "situs purbakala")
                startActivity(intent)
            }
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
