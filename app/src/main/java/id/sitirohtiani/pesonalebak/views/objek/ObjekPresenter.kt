package id.sitirohtiani.pesonalebak.views.main

import android.content.Context
import id.sitirohtiani.pesonalebak.base.ObjekView
import id.sitirohtiani.pesonalebak.base.Presenter

/**
 * Created by Rafi Lutfansyah on 12/02/2018.
 */

class ObjekPresenter(private val context: Context) : Presenter<ObjekView> {
    private var mView: ObjekView? = null

    override fun onAttach(view: ObjekView) {
        mView = view
    }

    override fun onDetach() {
        mView = null
    }
}