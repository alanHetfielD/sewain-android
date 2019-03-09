package com.madukubah.sewain.view.activity.books

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.madukubah.sewain.R
import kotlinx.android.synthetic.main.activity_books.*

class BooksActivity
    :
        AppCompatActivity(),
        BooksView.MView
{
    override fun status(isEmpty: Boolean) {

    }

    override fun setPresenter(presenter: BooksView.Presenter) {
        this.presenter = presenter as BooksPresenter
    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_books)
        presenter = BooksPresenter(this, this)
        presenter.start()

        rv_books.layoutManager = LinearLayoutManager(this)
        rv_books.adapter = presenter.adapter
    }

    lateinit var presenter : BooksPresenter
}
