package com.erwindevtech.firebasegooglesignin

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.erwindevtech.firebasegooglesignin.Fragment.FavoritesFragment
import com.erwindevtech.firebasegooglesignin.Fragment.HomeFragment
import com.erwindevtech.firebasegooglesignin.Fragment.SettingFragment
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val homeFragment = HomeFragment()
        val favoritesFragment = FavoritesFragment()
        val settingFragment = SettingFragment()

        makeCurrentFragment(homeFragment)

        bottom_navigation.setOnNavigationItemReselectedListener {
            when(it.itemId){
                R.id.ic_home -> makeCurrentFragment(homeFragment)
                R.id.ic_favorite -> makeCurrentFragment(favoritesFragment)
                R.id.ic_setting -> makeCurrentFragment(settingFragment)
            }
            true
        }
    }

    private fun makeCurrentFragment(fragment : Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper,fragment)
            commit()

    }


}