package id.sitirohtiani.pesonalebak.views.main

import android.content.Context
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import id.sitirohtiani.pesonalebak.R
import id.sitirohtiani.pesonalebak.base.MainView
import id.sitirohtiani.pesonalebak.base.Presenter

/**
 * Created by Rafi Lutfansyah on 12/02/2018.
 */

class MainPresenter(private val context: Context) : Presenter<MainView> {
    private var mView: MainView? = null
    private val mAuth = FirebaseAuth.getInstance()

    override fun onAttach(view: MainView) {
        mView = view
    }

    override fun onDetach() {
        mView = null
    }

    fun cekUser() {
        if (mAuth.currentUser != null) {
            //
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
                .addOnCompleteListener { task ->
                    val sharedPref = context.getSharedPreferences("data_mahasiswa", Context.MODE_PRIVATE)
                    val editor = sharedPref.edit()
                    editor.clear()
                    editor.commit()
                    mView!!.onSignOut()
                }
    }
}