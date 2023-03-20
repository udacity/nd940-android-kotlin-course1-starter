package com.udacity.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.udacity.shoestore.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    private val navController by lazy {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.myNavHostFragment) as NavHostFragment
        navHostFragment.navController
    }

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Logging
        Timber.plant(Timber.DebugTree())

        // Inflate
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Action Bar Setup and Configuration
        setupActionBar(binding, navController)
    }

    private fun setupActionBar(binding: ActivityMainBinding, navController: NavController) {
        appBarConfiguration = AppBarConfiguration(setOf(R.id.loginFragment, R.id.welcomeFragment, R.id.shoeListFragment))
        setSupportActionBar(binding.toolbar)
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) ||
                super.onSupportNavigateUp()
    }
}
