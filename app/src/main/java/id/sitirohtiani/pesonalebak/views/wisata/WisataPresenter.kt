package id.sitirohtiani.pesonalebak.views.main

import android.content.Context
import id.sitirohtiani.pesonalebak.base.Presenter
import id.sitirohtiani.pesonalebak.base.WisataView

/**
 * Created by Rafi Lutfansyah on 12/02/2018.
 */

class WisataPresenter(private val context: Context) : Presenter<WisataView> {
    private var mView: WisataView? = null

    override fun onAttach(view: WisataView) {
        mView = view
    }

    override fun onDetach() {
        mView = null
    }
}