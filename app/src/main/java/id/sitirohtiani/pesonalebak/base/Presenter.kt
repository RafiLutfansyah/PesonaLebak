package id.sitirohtiani.pesonalebak.base

/**
 * Created by Rafi Lutfansyah on 12/02/2018.
 */

interface Presenter<T : View> {
    fun onAttach(view: T)
    fun onDetach()
}