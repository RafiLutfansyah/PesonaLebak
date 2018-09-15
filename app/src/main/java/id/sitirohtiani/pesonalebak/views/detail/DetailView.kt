package id.sitirohtiani.pesonalebak.views.detail

import id.sitirohtiani.pesonalebak.base.View

/**
 * Created by Rafi Lutfansyah on 12/02/2018.
 */
interface DetailView : View {
    fun onResponseGetRating(rating: Int)
    fun onFailure(t: String)
}