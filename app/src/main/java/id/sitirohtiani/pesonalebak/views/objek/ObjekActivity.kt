package id.sitirohtiani.pesonalebak.views.objek

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import id.sitirohtiani.pesonalebak.R
import id.sitirohtiani.pesonalebak.base.ObjekView
import id.sitirohtiani.pesonalebak.views.main.ObjekPresenter
import kotlinx.android.synthetic.main.activity_objek.*

class ObjekActivity : AppCompatActivity(), ObjekView {
    var presenter: ObjekPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_objek)

        initPresenter()
        onAttachView()

        textTitle.text = intent.getStringExtra("title")
    }

    private fun initPresenter() {
        presenter = ObjekPresenter(this)
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
