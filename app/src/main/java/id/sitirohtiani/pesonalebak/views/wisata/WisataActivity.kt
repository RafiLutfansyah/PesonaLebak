package id.sitirohtiani.pesonalebak.views.wisata

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import id.sitirohtiani.pesonalebak.R
import id.sitirohtiani.pesonalebak.base.WisataView
import id.sitirohtiani.pesonalebak.views.main.WisataPresenter
import kotlinx.android.synthetic.main.activity_objek.*

class WisataActivity : AppCompatActivity(), WisataView {
    var presenter: WisataPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_objek)

        initPresenter()
        onAttachView()

        textTitle.text = intent.getStringExtra("title")
    }

    private fun initPresenter() {
        presenter = WisataPresenter(this)
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
