package com.madukubah.sewain.view.activity.books

import com.madukubah.sewain.config.base.BasePresenter
import com.madukubah.sewain.config.base.BaseView

interface BooksView
{
    interface Presenter : BasePresenter
    {
        fun loadData()

    }

    interface MView : BaseView<Presenter>
    {
        fun status(isEmpty : Boolean)

    }
}