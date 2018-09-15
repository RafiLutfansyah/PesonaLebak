package id.sitirohtiani.pesonalebak.base

import id.sitirohtiani.pesonalebak.adapter.ListReview

/**
 * Created by Rafi Lutfansyah on 12/02/2018.
 */
interface ReviewView : View {
    fun onResponse(listReview: ListReview)
    fun onFailure(t: String)
}