package com.madukubah.sewain.view.cari


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.madukubah.sewain.R
import com.madukubah.sewain.view.activity.books.BooksPresenter
import com.madukubah.sewain.view.activity.books.BooksView
import kotlinx.android.synthetic.main.fragment_cari.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class CariFragment
    :
        Fragment(),
        BooksView.MView
{
    override fun status(isEmpty: Boolean) {

    }

    override fun setPresenter(presenter: BooksView.Presenter) {

    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cari, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val ctx = checkNotNull(  context )
        ctx.let {
            presenter  =  BooksPresenter(this, it)
            presenter.start()
        }

        rv_cari_book.layoutManager = LinearLayoutManager(context)
        rv_cari_book.adapter = presenter.adapter
    }

    companion object {
        fun newInstance() : CariFragment
        {
            val instance = CariFragment()
            return instance
        }
    }

    lateinit var presenter : BooksPresenter
}
