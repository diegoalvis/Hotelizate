package com.diegoalvis.android.hotelizate.ui.activities

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import com.diegoalvis.android.hotelizate.R
import com.diegoalvis.android.hotelizate.api.ApiClient
import com.diegoalvis.android.hotelizate.databinding.ActivityMainBinding
import com.diegoalvis.android.hotelizate.ui.fragments.ListHotelsFragment
import com.diegoalvis.android.hotelizate.ui.fragments.SettingsFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by lazy { MainViewModel(this) }
    var listHotelsFragment = ListHotelsFragment()
    val settingsFragment = SettingsFragment()

    private val OnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        val transaction = supportFragmentManager.beginTransaction()
        when (item.itemId) {
            R.id.navigation_home -> {
                transaction.replace(R.id.container, settingsFragment)
                transaction.commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                transaction.replace(R.id.container, listHotelsFragment)
                transaction.commit()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, settingsFragment)
        transaction.commit()

        listHotelsFragment.viewModel = viewModel

        navigation.setOnNavigationItemSelectedListener(OnNavigationItemSelectedListener)
    }


}
