package id.sitirohtiani.pesonalebak.views.map

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import id.sitirohtiani.pesonalebak.R
import id.sitirohtiani.pesonalebak.base.MapView
import id.sitirohtiani.pesonalebak.views.main.MapPresenter

class MapActivity : AppCompatActivity(), MapView {
    var presenter: MapPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initPresenter()
        onAttachView()
    }

    private fun initPresenter() {
        presenter = MapPresenter(this)
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
