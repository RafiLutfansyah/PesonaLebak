package id.sitirohtiani.pesonalebak.views.detail

import android.content.Context
import id.sitirohtiani.pesonalebak.base.Presenter
import id.sitirohtiani.pesonalebak.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Rafi Lutfansyah on 12/02/2018.
 */

class DetailPresenter(private val context: Context) : Presenter<DetailView> {
    private var mView: DetailView? = null
    private var mApiService = RetrofitClient.getClient()

    override fun onAttach(view: DetailView) {
        mView = view
    }

    override fun onDetach() {
        mView = null
    }

    fun getRating(idWisata: Int) {
        mApiService.getRating("get", idWisata).enqueue(object : Callback<Int> {
            override fun onResponse(call: Call<Int>, response: Response<Int>) {
                mView!!.onResponseGetRating(response.body()!!)
            }

            override fun onFailure(call: Call<Int>, t: Throwable) {
                mView!!.onFailure(t.toString())
            }
        })
    }
}