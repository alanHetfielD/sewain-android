package com.madukubah.sewain.view.activity.sub_category

import android.app.Activity
import com.madukubah.sewain.model.Category
import com.madukubah.sewain.model.response.CategoryResponse
import com.madukubah.sewain.view.activity.sub_category.adapter.AdapterSubCategory

class SubCategoryPresenter
(
        val view : SubCategoryView.MView
) : SubCategoryView.Presenter
{
    override fun loadData() {
        view.showLoading()
        view.status( false )
        subCategories.clear()
        adapter.notifyDataSetChanged()
    }

    override fun loadSubCategory(response: CategoryResponse) {
        view.hideLoading()
        if( response.categories.size <=0 )
        {
            view.status( true )
            return
        }
        view.status( false )
        subCategories.addAll( response.categories )
        adapter.notifyDataSetChanged()
    }

    override fun start() {
        val subcategory = listOf(
                Category( 1, 1, 1, 1, "Novel", "Novel", 1 ),
                Category( 1, 1, 1, 1, "Komik", "Komik", 1 )
        )
        subCategories.addAll(subcategory)
        val ctx =  view as Activity
        adapter = AdapterSubCategory(ctx , subCategories)
        adapter.notifyDataSetChanged()
    }

    internal lateinit var adapter  : AdapterSubCategory
    internal var subCategories : MutableList<Category> = mutableListOf()
}