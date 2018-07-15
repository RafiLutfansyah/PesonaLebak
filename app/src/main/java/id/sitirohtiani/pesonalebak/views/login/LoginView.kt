package id.sitirohtiani.pesonalebak.views.login

import android.content.Intent
import id.sitirohtiani.pesonalebak.base.View

/**
 * Created by Rafi Lutfansyah on 16/02/2018.
 */

interface LoginView : View {
    fun signIn(signInIntent: Intent, RC_SIGN: Int)
    fun onActivityResultSuccess()
    fun onActivityResultError()
    fun signInWithCredentialSuccess()
    fun signInWithCredentialError()
    fun onLoginSuccess()
}