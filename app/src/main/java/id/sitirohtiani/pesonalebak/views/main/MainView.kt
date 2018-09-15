package id.sitirohtiani.pesonalebak.base

import java.util.ArrayList

/**
 * Created by Rafi Lutfansyah on 12/02/2018.
 */
interface MainView : View {
    fun onSignOut()
    fun onShowMainCarousel(listUrl: ArrayList<String>, listName: ArrayList<String>)
}