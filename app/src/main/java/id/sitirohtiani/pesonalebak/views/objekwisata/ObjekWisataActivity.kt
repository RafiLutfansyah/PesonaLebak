package id.sitirohtiani.pesonalebak.views.objekwisata

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import id.sitirohtiani.pesonalebak.R
import id.sitirohtiani.pesonalebak.adapter.ListWisata
import kotlinx.android.synthetic.main.activity_objek.*
import kotlinx.android.synthetic.main.activity_objek_wisata.*

class ObjekWisataActivity : AppCompatActivity(), ObjekWisataView {
    var presenter: ObjekWisataPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_objek_wisata)

        initPresenter()
        onAttachView()

        Toast.makeText(this, "${intent.getStringExtra("destinasi")} - ${intent.getStringExtra("wisata")}", Toast.LENGTH_SHORT).show()

        listWisata.setHasFixedSize(true)
        listWisata.layoutManager = LinearLayoutManager(this)

        presenter!!.getListWisata(intent.getStringExtra("destinasi"), intent.getStringExtra("wisata"))
    }

    override fun onSuccess(adapter: ListWisata) {
        listWisata.adapter = adapter
    }

    private fun initPresenter() {
        presenter = ObjekWisataPresenter(this)
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
