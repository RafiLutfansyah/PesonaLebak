package id.sitirohtiani.pesonalebak.views.main

import android.content.Context
import id.sitirohtiani.pesonalebak.base.ObjekWisataView
import id.sitirohtiani.pesonalebak.base.Presenter

/**
 * Created by Rafi Lutfansyah on 12/02/2018.
 */

class ObjekWisataPresenter(private val context: Context) : Presenter<ObjekWisataView> {
    private var mView: ObjekWisataView? = null

    override fun onAttach(view: ObjekWisataView) {
        mView = view
    }

    override fun onDetach() {
        mView = null
    }
}