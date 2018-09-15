package id.sitirohtiani.pesonalebak.base

import id.sitirohtiani.pesonalebak.model.Rating

/**
 * Created by Rafi Lutfansyah on 12/02/2018.
 */
interface RatingView : View {
    fun onResponse(string: String)
    fun onFailure(t: String)
    fun onSuccess(t: String)
    fun onFailed(t: String)
}