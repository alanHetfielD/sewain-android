package com.madukubah.sewain.view.activity.books

import android.content.Context
import android.os.Build
import com.madukubah.sewain.R
import com.madukubah.sewain.model.Book
import com.madukubah.sewain.view.activity.books.adapter.BooksAdapter

class BooksPresenter
(
        val view : BooksView.MView,
        val ctx : Context
) : BooksView.Presenter
{
    override fun loadData() {

    }

    override fun start() {

        val desc= ctx.resources.getString(R.string.phone)
        books = listOf(
                Book(1, "Promise - Ketika Janji Menjadi Begitu Berarti", "LalunaKia", "9 Des 2018", "9786020387840", "Indonesia", "Gramedia Pustaka Utama", "0.185", "13.5","20",desc , "272 Halaman"),
                Book(1, "Promise - Ketika Janji Menjadi Begitu Berarti", "LalunaKia", "9 Des 2018", "9786020387840", "Indonesia", "Gramedia Pustaka Utama", "0.185", "13.5","20",desc , "272 Halaman"),
                Book(1, "Promise - Ketika Janji Menjadi Begitu Berarti", "LalunaKia", "9 Des 2018", "9786020387840", "Indonesia", "Gramedia Pustaka Utama", "0.185", "13.5","20",desc , "272 Halaman"),
                Book(1, "Promise - Ketika Janji Menjadi Begitu Berarti", "LalunaKia", "9 Des 2018", "9786020387840", "Indonesia", "Gramedia Pustaka Utama", "0.185", "13.5","20",desc , "272 Halaman"),
                Book(1, "Promise - Ketika Janji Menjadi Begitu Berarti", "LalunaKia", "9 Des 2018", "9786020387840", "Indonesia", "Gramedia Pustaka Utama", "0.185", "13.5","20",desc , "272 Halaman"),
                Book(1, "Promise - Ketika Janji Menjadi Begitu Berarti", "LalunaKia", "9 Des 2018", "9786020387840", "Indonesia", "Gramedia Pustaka Utama", "0.185", "13.5","20",desc, "272 Halaman" )
        ).toMutableList()

        adapter = BooksAdapter(ctx, books)
        adapter.notifyDataSetChanged()
    }

    internal lateinit var adapter  : BooksAdapter
    internal var books : MutableList<Book> = mutableListOf()
}