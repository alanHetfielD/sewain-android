package com.madukubah.sewain.view.activity.books.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.madukubah.sewain.R
import com.madukubah.sewain.model.Book
import com.madukubah.sewain.view.activity.detail_book.DetailBookActivity
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_list_book.view.*
import org.jetbrains.anko.startActivity

class BooksAdapter
(
        private val context: Context,
        private val items: List<Book>
) : RecyclerView.Adapter<BooksAdapter.ViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = ViewHolder( LayoutInflater.from(context).inflate(R.layout.item_list_book, parent, false) )

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem( items[ position ] )
    }

    class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {
        fun bindItem(item: Book ) {
            containerView.tv_item_name.text = item.book_title
            containerView.tv_item_author.text = item.book_author
            containerView.tv_item_desc.text = item.book_desc


            val ctx = containerView.context
//            val images = items.place_image.split(";")

//            Glide.with(containerView).load(BuildConfig.PLACE_IMAGE + images[0] ).into(containerView.img_item_photo)
            containerView.btn_detail.setOnClickListener {
                ctx.let {
                    it.startActivity<DetailBookActivity>(
                            DetailBookActivity.BOOK to item
                    )
                }
            }
        }
    }
}