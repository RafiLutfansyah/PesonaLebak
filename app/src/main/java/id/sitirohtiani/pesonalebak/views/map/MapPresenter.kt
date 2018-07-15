package id.sitirohtiani.pesonalebak.views.main

import android.content.Context
import id.sitirohtiani.pesonalebak.base.MapView
import id.sitirohtiani.pesonalebak.base.Presenter

/**
 * Created by Rafi Lutfansyah on 12/02/2018.
 */

class MapPresenter(private val context: Context) : Presenter<MapView> {
    private var mView: MapView? = null

    override fun onAttach(view: MapView) {
        mView = view
    }

    override fun onDetach() {
        mView = null
    }
}