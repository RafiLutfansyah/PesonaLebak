package id.sitirohtiani.pesonalebak.views.objekwisata

import android.content.Context
import android.util.Log
import id.sitirohtiani.pesonalebak.adapter.ListWisata
import id.sitirohtiani.pesonalebak.base.Presenter
import id.sitirohtiani.pesonalebak.model.Wisata
import id.sitirohtiani.pesonalebak.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Rafi Lutfansyah on 12/02/2018.
 */

class ObjekWisataPresenter(private val context: Context) : Presenter<ObjekWisataView> {
    private var mView: ObjekWisataView? = null
    private var mApiService = RetrofitClient.getClient()

    override fun onAttach(view: ObjekWisataView) {
        mView = view
    }

    override fun onDetach() {
        mView = null
    }

    fun getListWisata(destinasi: String, wisata: String) {
        mApiService.getListWisata(destinasi, wisata).enqueue(object : Callback<List<Wisata>> {
            override fun onResponse(call: Call<List<Wisata>>?, response: Response<List<Wisata>>?) {
                val response = response!!.body()
                mView!!.onSuccess(ListWisata(response!!))
            }

            override fun onFailure(call: Call<List<Wisata>>?, t: Throwable?) {
                Log.d("onFailure", t.toString())
            }
        })
    }
}