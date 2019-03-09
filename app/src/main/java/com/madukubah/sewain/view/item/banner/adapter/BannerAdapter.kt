package com.madukubah.pariwisata.view.item.banner.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.madukubah.pariwisata.view.item.banner.BannerFragment
import com.madukubah.sewain.model.BannerPromo

class BannerAdapter(fragmentManager: FragmentManager,
                    private val banners: List<BannerPromo>) : FragmentPagerAdapter(fragmentManager) {

    override fun getItem(pos: Int): Fragment {
        return BannerFragment.newInstance(banners[pos].image)
    }
    override fun getCount(): Int = banners.size
}