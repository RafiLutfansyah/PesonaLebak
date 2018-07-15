package id.sitirohtiani.pesonalebak.views.main

import android.content.Context
import id.sitirohtiani.pesonalebak.base.DetailView
import id.sitirohtiani.pesonalebak.base.Presenter

/**
 * Created by Rafi Lutfansyah on 12/02/2018.
 */

class DetailPresenter(private val context: Context) : Presenter<DetailView> {
    private var mView: DetailView? = null

    override fun onAttach(view: DetailView) {
        mView = view
    }

    override fun onDetach() {
        mView = null
    }
}