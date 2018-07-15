package id.sitirohtiani.pesonalebak.views.objekwisata

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import id.sitirohtiani.pesonalebak.R
import id.sitirohtiani.pesonalebak.base.ObjekWisataView
import id.sitirohtiani.pesonalebak.views.main.ObjekWisataPresenter

class ObjekWisataActivity : AppCompatActivity(), ObjekWisataView {
    var presenter: ObjekWisataPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initPresenter()
        onAttachView()
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
