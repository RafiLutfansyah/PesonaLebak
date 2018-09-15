package id.sitirohtiani.pesonalebak.views.review

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import id.sitirohtiani.pesonalebak.R
import id.sitirohtiani.pesonalebak.adapter.ListReview
import id.sitirohtiani.pesonalebak.base.ReviewView
import kotlinx.android.synthetic.main.activity_review.*

class ReviewActivity : AppCompatActivity(), ReviewView {
    private var presenter: ReviewPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review)

        initPresenter()
        onAttachView()

        rvReview.setHasFixedSize(true)
        rvReview.layoutManager = LinearLayoutManager(this)

        Toast.makeText(this, intent.getStringExtra("idWisata"), Toast.LENGTH_SHORT).show()

        presenter!!.getListReview(intent.getStringExtra("idWisata").toInt())

        bReview.setOnClickListener {
            presenter!!.postReview(intent.getStringExtra("idWisata").toInt(), etReview.text.toString())
        }
    }

    override fun onResponse(list: ListReview) {
        rvReview.adapter = list
    }

    override fun onFailure(t: String) {
        Toast.makeText(this, t, Toast.LENGTH_SHORT).show()
    }

    private fun initPresenter() {
        presenter = ReviewPresenter(this)
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
}
