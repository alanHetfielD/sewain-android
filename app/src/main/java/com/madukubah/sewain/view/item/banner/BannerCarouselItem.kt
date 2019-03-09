package com.madukubah.pariwisata.view.item.banner

import android.support.v4.app.FragmentManager
import com.madukubah.pariwisata.view.item.banner.adapter.BannerAdapter
import com.madukubah.sewain.R
import com.madukubah.sewain.model.BannerPromo
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.item_carousel_banner.view.*

interface BannerListener {
    fun onSeeAllPromoClick()
    fun onBannerClick(promo: BannerPromo)
}

class BannerCarouselItem(private val banners: List<BannerPromo>,
                         private val supportFragmentManager: FragmentManager?,
                         private val listener: BannerListener) : Item() {

    override fun bind(viewHolder: ViewHolder, position: Int) {
        val viewPagerAdapter = supportFragmentManager?.let { BannerAdapter(it, banners) }
        viewHolder.itemView.viewPagerBanner.adapter = viewPagerAdapter
        viewHolder.itemView.indicator.setViewPager(viewHolder.itemView.viewPagerBanner)

        viewHolder.itemView.btnSemuaPromo.setOnClickListener {
            listener.onSeeAllPromoClick()
        }
    }

    override fun getLayout(): Int = R.layout.item_carousel_banner
}