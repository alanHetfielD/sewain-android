package com.madukubah.sewain.view.activity.sub_category.adapter

import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.madukubah.sewain.R
import com.madukubah.sewain.model.Category
import com.madukubah.sewain.view.activity.books.BooksActivity
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_list_subcategory.view.*
import org.jetbrains.anko.startActivity

class AdapterSubCategory
(
        private val context: Context,
        private val items: List<Category>
): RecyclerView.Adapter<AdapterSubCategory.ViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = ViewHolder( LayoutInflater.from(context).inflate(R.layout.item_list_subcategory, parent, false) )

    override fun getItemCount()
            = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem( items[position]  )
    }


    class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {
        fun bindItem(items: Category) {
            containerView.subcategory_name.text = items.category_place_name.toLowerCase().capitalize()

            val ctx = containerView.context
            ctx.let {
                containerView.subcategory_image.setColorFilter(
                        ContextCompat.getColor(
                                it,
                                R.color.colorPrimary
                        )
                )
            }
//            Glide.with(containerView).load(items.image).into(containerView.image)
            itemView.setOnClickListener {
                ctx.let {
                    it.startActivity<BooksActivity>(

                    )
                }
            }
        }
    }
}