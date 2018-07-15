package id.sitirohtiani.pesonalebak.views.detail

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import id.sitirohtiani.pesonalebak.R
import id.sitirohtiani.pesonalebak.base.DetailView
import id.sitirohtiani.pesonalebak.views.main.DetailPresenter

class DetailActivity : AppCompatActivity(), DetailView {
    var presenter: DetailPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initPresenter()
        onAttachView()
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
