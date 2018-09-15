package id.sitirohtiani.pesonalebak.views.rating

import android.content.Context
import com.google.firebase.auth.FirebaseAuth
import id.sitirohtiani.pesonalebak.base.Presenter
import id.sitirohtiani.pesonalebak.base.RatingView
import id.sitirohtiani.pesonalebak.model.Rating
import id.sitirohtiani.pesonalebak.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Rafi Lutfansyah on 12/02/2018.
 */

class RatingPresenter(private val context: Context) : Presenter<RatingView> {
    private var mView: RatingView? = null
    private var mApiService = RetrofitClient.getClient()
    private val email = FirebaseAuth.getInstance().currentUser!!.email

    override fun onAttach(view: RatingView) {
        mView = view
    }

    override fun onDetach() {
        mView = null
    }

    fun checkRating(idWisata: Int) {
        mApiService.checkRating("check", idWisata, email!!).enqueue(object : Callback<List<Rating>> {
            override fun onResponse(call: Call<List<Rating>>, response: Response<List<Rating>>) {
                if(response.body()!!.toString() == "[]") {
                    mView!!.onFailure("Masukan Rating!")
                } else {
                    mView!!.onResponse(response.body()!![0].rating)
                }
            }

            override fun onFailure(call: Call<List<Rating>>, t: Throwable) {
                mView!!.onFailure(t.toString())
            }
        })
    }

    fun setRating(idWisata: Int, rating: Float) {
        mApiService.setRating(idWisata, email!!, rating).enqueue(object : Callback<List<Rating>> {
            override fun onFailure(call: Call<List<Rating>>, t: Throwable) {
                mView!!.onFailed(t.toString())
            }

            override fun onResponse(call: Call<List<Rating>>, response: Response<List<Rating>>) {
                mView!!.onSuccess(response.toString())
            }
        })
    }
}