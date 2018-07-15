package id.sitirohtiani.pesonalebak.views.login

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import id.sitirohtiani.pesonalebak.R
import id.sitirohtiani.pesonalebak.views.main.MainActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginView {

    var presenter: LoginPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initPresenter()
        onAttachView()

        signInButton.setOnClickListener {
            presenter!!.signIn()
        }
    }

    private fun initPresenter() {
        presenter = LoginPresenter(this)
    }

    override fun onAttachView() {
        presenter!!.onAttach(this)
    }

    override fun onDetachView() {
        presenter!!.onDetach()
    }

    override fun onDestroy() {
        onDetachView()
        super.onDestroy()
    }

    override fun signIn(signInIntent: Intent, RC_SIGN_IN: Int) {
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)
        presenter!!.onActivityResult(requestCode, data)
    }

    override fun onActivityResultSuccess() {
        Toast.makeText(this, "Google Sign In was successful, authenticate with Firebase", Toast.LENGTH_SHORT).show()
    }

    override fun onActivityResultError() {
        Toast.makeText(this, "Google sign in failed", Toast.LENGTH_SHORT).show()
    }

    override fun signInWithCredentialSuccess() {
        Toast.makeText(this, "signInWithCredential:success", Toast.LENGTH_SHORT).show()
    }

    override fun signInWithCredentialError() {
        Toast.makeText(this, "Authentication Failed.", Toast.LENGTH_SHORT).show()
    }

    override fun onLoginSuccess() {
        startActivity(Intent(this, MainActivity::class.java))
    }
}