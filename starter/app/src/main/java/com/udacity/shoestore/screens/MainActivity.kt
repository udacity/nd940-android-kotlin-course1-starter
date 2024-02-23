package com.udacity.shoestore.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.get
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupActionBarWithNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: ShoeListingViewModel
    private lateinit var appBar: AppBarConfiguration
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this)[ShoeListingViewModel::class.java]

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.myNavHostFragment) as NavHostFragment
        navController = navHostFragment.navController

        appBar = AppBarConfiguration(navController.graph)

        setSupportActionBar(binding.toolBar)
        setupActionBarWithNavController(navController, appBar)
        NavigationUI.setupActionBarWithNavController(this, navController)
//        NavigationUI.setupWithNavController(binding.navView, navController)
        navController.addOnDestinationChangedListener{ nc: NavController, navDestination: NavDestination, _ ->

            when (navDestination.id) {
                R.id.shoeListingFragment -> toggleSupportActionBar(true)
                else -> toggleSupportActionBar(false)
            }

            when (navDestination.id) {
                R.id.shoeDetailEditingFragment -> toggleUpButton(true)
                else -> toggleUpButton(false)
            }
//
//            if (navDestination.id == R.id.onboardFragment) {
//                supportActionBar?.setDisplayHomeAsUpEnabled(false)
//            } else {
//                supportActionBar?.setDisplayHomeAsUpEnabled(true)
//            }

        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return navController.navigateUp(appBar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        if (navController.currentDestination?.id == R.id.shoeListingFragment ) {
            menuInflater.inflate(R.menu.menu, menu)
        }
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.logout_action) {
            navController.popBackStack(R.id.loginFragment, false)
        }
        return super.onOptionsItemSelected(item)
    }

    private fun toggleSupportActionBar(enabled: Boolean) {
        if (enabled) supportActionBar?.show() else supportActionBar?.hide()
    }

    private fun toggleUpButton(enabled: Boolean) {
        supportActionBar?.setDisplayHomeAsUpEnabled(enabled)
    }
}
