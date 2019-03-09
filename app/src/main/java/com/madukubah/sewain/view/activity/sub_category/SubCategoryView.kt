package com.madukubah.sewain.view.activity.sub_category

import com.madukubah.sewain.config.base.BasePresenter
import com.madukubah.sewain.config.base.BaseView
import com.madukubah.sewain.model.response.CategoryResponse

interface SubCategoryView
{
    interface Presenter : BasePresenter
    {
        fun loadData()
        fun loadSubCategory( response : CategoryResponse)
    }

    interface MView : BaseView<Presenter>
    {
        fun status(isEmpty : Boolean)
    }
}