package com.madukubah.sewain.view.activity.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.view.MenuItem
import com.madukubah.sewain.R
import com.madukubah.sewain.view.buku.BukuFragment
import com.madukubah.sewain.view.cari.CariFragment
import com.madukubah.sewain.view.tentang.TentangFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity
    :
        AppCompatActivity(),
        BottomNavigationView.OnNavigationItemSelectedListener
{
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        when(id){
            R.id.navigation_buku->{
                manager.beginTransaction().hide(active).show(bukuFragment).commit()
                active = bukuFragment
                return true
            }
            R.id.navigation_cari->{
                manager.beginTransaction().hide(active).show(cariFragment).commit()
                active = cariFragment
                return true
            }
            R.id.navigation_tentang ->{
                manager.beginTransaction().hide(active).show(tentangFragment).commit()
                active = tentangFragment
                return true
            }
        }
        return false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        manager.beginTransaction().add(R.id.frame,  cariFragment ).hide( cariFragment).commit()
        manager.beginTransaction().add(R.id.frame,  tentangFragment ).hide( tentangFragment).commit()
        manager.beginTransaction().add(R.id.frame,  bukuFragment  ).commit()

        navigation.setOnNavigationItemSelectedListener(this)
    }

    val manager = supportFragmentManager
    val bukuFragment : BukuFragment = BukuFragment.newInstance()
    val cariFragment : CariFragment = CariFragment.newInstance()
    val tentangFragment : TentangFragment = TentangFragment.newInstance()
    var active : Fragment = bukuFragment
}
