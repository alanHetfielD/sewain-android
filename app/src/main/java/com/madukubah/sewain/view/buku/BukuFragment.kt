package com.madukubah.sewain.view.buku


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.madukubah.pariwisata.view.item.banner.BannerCarouselItem
import com.madukubah.pariwisata.view.item.banner.BannerListener
import com.madukubah.pariwisata.view.item.category.CategoryItem
import com.madukubah.pariwisata.view.item.category.CategoryListener
import com.madukubah.pariwisata.view.item.category.ItemCategories

import com.madukubah.sewain.R
import com.madukubah.sewain.model.BannerPromo
import com.madukubah.sewain.model.Category
import com.madukubah.sewain.view.activity.sub_category.SubCategoryActivity
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.fragment_buku.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.jetbrains.anko.support.v4.startActivity
import org.jetbrains.anko.support.v4.toast

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class BukuFragment
    :
        Fragment(),
        BannerListener,
        CategoryListener,
        AnkoLogger
{
    override fun onSeeAllPromoClick() {
        toast("onSeeAllPromoClick")
    }

    override fun onBannerClick(promo: BannerPromo) {
        toast("onBannerClick")
    }

    override fun onCategoryClicked(category: Category) {
        startActivity<SubCategoryActivity>(

        )
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_buku, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        info { "CREATE" }
        val promos = listOf(
                BannerPromo(name = "Puncak badai uang",
                        image = "https://s2.bukalapak.com/uploads/promo_partnerinfo_bloggy/2842/Bloggy_1_puncak.jpg"),
                BannerPromo(
                        name = "hati hati ada guncangan badai uang",
                        image = "https://s4.bukalapak.com/uploads/promo_partnerinfo_bloggy/5042/Bloggy_1.jpg"
                ),
                BannerPromo(name = "Puncak badai uang",
                        image = "https://s2.bukalapak.com/uploads/promo_partnerinfo_bloggy/2842/Bloggy_1_puncak.jpg"),
                BannerPromo(
                        name = "hati hati ada guncangan badai uang",
                        image = "https://s4.bukalapak.com/uploads/promo_partnerinfo_bloggy/5042/Bloggy_1.jpg"
                ),
                BannerPromo(name = "Puncak badai uang",
                        image = "https://s2.bukalapak.com/uploads/promo_partnerinfo_bloggy/2842/Bloggy_1_puncak.jpg"),
                BannerPromo(
                        name = "hati hati ada guncangan badai uang",
                        image = "https://s4.bukalapak.com/uploads/promo_partnerinfo_bloggy/5042/Bloggy_1.jpg"
                )
        )

    val categories : List<Category> = listOf(
                Category( 11, 1, 1, 11, "Agama", "Agama" , 11),
                Category( 1, 1, 1, 1, "Agrikultur", "Agrikultur" , 1),
                Category( 1, 1, 1, 1, "Bisnis", "Bisnis" , 1),
                Category( 1, 1, 1, 1, "Buku Anak", "Buku Anak" , 1),
                Category( 1, 1, 1, 1, "Desain", "Desain" , 1),
                Category( 1, 1, 1, 1, "Fashion", "Fashion" , 1),
                Category( 1, 1, 1, 1, "Kesehatan", "Kesehatan" , 1),
                Category( 1, 1, 1, 1, "Pelajaran", "Pelajaran" , 1)
        )

        rvMain.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = groupAdapter
        }

        val fm = getFragmentManager()
        val bannerCarouselItem = BannerCarouselItem(promos, fm, this)
        groupAdapter.add(bannerCarouselItem)

        Section().apply {
            add( makeCategories( categories ) )
            groupAdapter.add(this)
        }
    }

    private fun makeCategories( categories : List<Category> ) : ItemCategories
    {
        val categoryAdapter = GroupAdapter<ViewHolder>()
        val ctx = context
        categories.map {
            categoryAdapter.add( CategoryItem( it, ctx , this  ) )
        }
        return ItemCategories( categoryAdapter )
    }

    companion object {
        fun newInstance() : BukuFragment
        {
            val instance = BukuFragment()

            return instance
        }
    }
    private var groupAdapter = GroupAdapter<ViewHolder>()
}
