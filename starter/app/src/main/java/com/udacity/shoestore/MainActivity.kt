package com.udacity.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.navOptions
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.udacity.shoestore.databinding.ActivityMainBinding
import com.udacity.shoestore.viewmodels.ShoeListingViewModel


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
        navController.addOnDestinationChangedListener{ _, navDestination: NavDestination, _ ->

            when (navDestination.id) {
                R.id.shoeListingFragment -> toggleSupportActionBar(true)
                R.id.shoeDetailEditingFragment -> toggleSupportActionBar(true)
                else -> toggleSupportActionBar(false)
            }

            when (navDestination.id) {
                R.id.shoeDetailEditingFragment -> toggleUpButton(true)
                else -> toggleUpButton(false)
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return navController.navigateUp(appBar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.logout_action) {
            navController.navigate(R.id.loginFragment, null, navOptions = navOptions {
                this.popUpTo(R.id.shoeListingFragment){
                    inclusive = true
                }
            })
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
