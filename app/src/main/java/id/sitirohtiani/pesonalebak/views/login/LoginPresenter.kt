package id.sitirohtiani.pesonalebak.views.login

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import id.sitirohtiani.pesonalebak.R
import id.sitirohtiani.pesonalebak.base.Presenter
import id.sitirohtiani.pesonalebak.model.User
import id.sitirohtiani.pesonalebak.model.Wisata
import id.sitirohtiani.pesonalebak.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

/**
 * Created by Rafi Lutfansyah on 16/02/2018.
 */

class LoginPresenter(val context: Context) : Presenter<LoginView> {

    private var mView: LoginView? = null

    private val TAG = "GoogleActivity"
    private val RC_SIGN_IN = 9001
    private val mAuth = FirebaseAuth.getInstance()
    private val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken(context.getString(R.string.default_web_client_id)).requestEmail().build()
    private val mGoogleSignInClient: GoogleSignInClient? = GoogleSignIn.getClient(context, gso)

    private var mApiService = RetrofitClient.getClient()

    override fun onAttach(view: LoginView) {
        mView = view
    }

    override fun onDetach() {
        mView = null
    }

    fun signIn() {
        val signInIntent = mGoogleSignInClient!!.signInIntent
        mView!!.signIn(signInIntent, RC_SIGN_IN)
    }

    fun onActivityResult(requestCode: Int, data: Intent) {
        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                val account = task.getResult(ApiException::class.java)
                firebaseAuthWithGoogle(account)
                mView!!.onActivityResultSuccess()
            } catch (e: ApiException) {
                Log.w(TAG, "Google sign in failed", e)
                mView!!.onActivityResultError()
            }
        }
    }

    fun firebaseAuthWithGoogle(acct: GoogleSignInAccount) {
        Log.d(TAG, "firebaseAuthWithGoogle:" + acct.id)

        val credential = GoogleAuthProvider.getCredential(acct.idToken, null)
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Log.d(TAG, "signInWithCredential:success")
                        val user = mAuth.currentUser
                        if (user != null) {
                            cekUser(user)
                        }
                    } else {
                        Log.w(TAG, "signInWithCredential:failure", task.exception)
                        mView!!.signInWithCredentialError()
                    }
                }
    }

    private fun cekUser(user: FirebaseUser) {
        mApiService.getUser(user.email!!).enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>?, response: Response<User>?) {
                val response = response!!.body()
                Log.d("onResponse", response.toString())
                mView!!.onLoginSuccess()
            }

            override fun onFailure(call: Call<User>?, t: Throwable?) {
                Log.d("onFailure", t.toString())
                register(user)
            }
        })
    }

    private fun register(user: FirebaseUser) {
        mApiService.postUser(user.email!!, user.displayName!!, user.photoUrl!!).enqueue(object :Callback<User>{
            override fun onResponse(call: Call<User>, response: Response<User>) {
                mView!!.onLoginSuccess()
            }
            override fun onFailure(call: Call<User>, t: Throwable) {
                Log.d("onFailure", t.toString())
                signOut()
            }
        })
    }

    fun signOut() {
        mAuth!!.signOut()
        mGoogleSignInClient!!.signOut()
    }
}