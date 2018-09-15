package id.sitirohtiani.pesonalebak.views.main

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import id.sitirohtiani.pesonalebak.R
import id.sitirohtiani.pesonalebak.base.MainView
import id.sitirohtiani.pesonalebak.base.Presenter
import id.sitirohtiani.pesonalebak.model.Wisata
import id.sitirohtiani.pesonalebak.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

/**
 * Created by Rafi Lutfansyah on 12/02/2018.
 */

class MainPresenter(private val context: Context) : Presenter<MainView> {
    private var mView: MainView? = null
    private val mAuth = FirebaseAuth.getInstance()
    private var mApiService = RetrofitClient.getClient()

    override fun onAttach(view: MainView) {
        mView = view
    }

    override fun onDetach() {
        mView = null
    }

    fun cekUser() {
        if (mAuth.currentUser != null) {
            getMainCorousel()
        }
        else {
            signOut()
        }
    }

    fun signOut() {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(context.getString(R.string.default_web_client_id))
                .requestEmail()
                .build()
        val mGoogleSignInClient: GoogleSignInClient? = GoogleSignIn.getClient(context, gso)

        mAuth!!.signOut()
        mGoogleSignInClient!!.signOut()
                .addOnCompleteListener {
                    mView!!.onSignOut()
                }
    }

    private fun getMainCorousel() {
        mApiService.getMainCorousel().enqueue(object : Callback<List<Wisata>> {
            override fun onResponse(call: Call<List<Wisata>>?, response: Response<List<Wisata>>?) {
                val listUrl = ArrayList<String>()
                val listName = ArrayList<String>()

                for (i in response!!.body()!!) {
                    val fotoUrl = i.urlFoto

                    val urlFoto = fotoUrl.split(" ")
                    Collections.shuffle(urlFoto)
                    listUrl.add(urlFoto[0])
                    listName.add(i.nama)
                }

                mView!!.onShowMainCarousel(listUrl, listName)

            }

            override fun onFailure(call: Call<List<Wisata>>?, t: Throwable?) {
                Log.d("onFailure", t.toString())
            }
        })
    }
}