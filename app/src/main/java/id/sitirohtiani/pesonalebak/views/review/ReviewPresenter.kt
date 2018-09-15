package id.sitirohtiani.pesonalebak.views.review

import android.content.Context
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import id.sitirohtiani.pesonalebak.adapter.ListReview
import id.sitirohtiani.pesonalebak.adapter.ListWisata
import id.sitirohtiani.pesonalebak.base.ReviewView
import id.sitirohtiani.pesonalebak.base.Presenter
import id.sitirohtiani.pesonalebak.model.Review
import id.sitirohtiani.pesonalebak.model.Wisata
import id.sitirohtiani.pesonalebak.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Rafi Lutfansyah on 12/02/2018.
 */

class ReviewPresenter(private val context: Context) : Presenter<ReviewView> {
    private var mView: ReviewView? = null
    private var mApiService = RetrofitClient.getClient()
    private val email = FirebaseAuth.getInstance().currentUser!!.email

    override fun onAttach(view: ReviewView) {
        mView = view
    }

    override fun onDetach() {
        mView = null
    }

    fun getListReview(idWisata: Int) {
        mApiService.getListReview(idWisata).enqueue(object : Callback<List<Review>> {
            override fun onResponse(call: Call<List<Review>>?, response: Response<List<Review>>?) {
                val response = response!!.body()
                mView!!.onResponse(ListReview(response!!))
            }

            override fun onFailure(call: Call<List<Review>>?, t: Throwable?) {
                Log.d("onFailure", t.toString())
                mView!!.onFailure(t.toString())
            }
        })
    }

    fun postReview(idWisata: Int, review: String) {
        mApiService.postReview(idWisata, email!!, review).enqueue(object : Callback<List<Review>>{
            override fun onResponse(call: Call<List<Review>>, response: Response<List<Review>>) {
                val response = response!!.body()
                mView!!.onResponse(ListReview(response!!))
            }

            override fun onFailure(call: Call<List<Review>>, t: Throwable) {
                Log.d("onFailure", t.toString())
                mView!!.onFailure(t.toString())
            }

        })
    }
}