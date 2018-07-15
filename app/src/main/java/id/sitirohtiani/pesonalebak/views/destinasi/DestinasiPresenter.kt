package id.sitirohtiani.pesonalebak.views.main

import android.content.Context
import id.sitirohtiani.pesonalebak.base.DestinasiView
import id.sitirohtiani.pesonalebak.base.Presenter

/**
 * Created by Rafi Lutfansyah on 12/02/2018.
 */

class DestinasiPresenter(private val context: Context) : Presenter<DestinasiView> {
    private var mView: DestinasiView? = null

    override fun onAttach(view: DestinasiView) {
        mView = view
    }

    override fun onDetach() {
        mView = null
    }
}