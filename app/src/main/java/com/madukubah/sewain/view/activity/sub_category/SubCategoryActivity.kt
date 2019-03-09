package com.madukubah.sewain.view.activity.sub_category

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.madukubah.sewain.R
import com.madukubah.sewain.model.Category
import kotlinx.android.synthetic.main.activity_sub_category.*

class SubCategoryActivity
    :
        AppCompatActivity(),
        SubCategoryView.MView
{
    override fun status(isEmpty: Boolean) {

    }

    override fun setPresenter(presenter: SubCategoryView.Presenter) {
        this.presenter = presenter as SubCategoryPresenter
    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub_category)

        presenter = SubCategoryPresenter(this)
        presenter.start()

        rv_subcategory.layoutManager = LinearLayoutManager( this )
        rv_subcategory.adapter = presenter.adapter
    }

    internal lateinit var category : Category
    lateinit var presenter: SubCategoryPresenter
}
