package com.udacity.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.onNavDestinationSelected
import com.udacity.shoestore.screens.login.LoginFragmentDirections
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // initialize a variable for the appBarConfiguration
    private lateinit var appBarConfiguration: AppBarConfiguration

    // initialize a variable for the nav controller
    lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))


        // Create a NavController instance

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        // assigning ID of the toolbar to a var
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar

        // using toolbar as an ActionBar
        setSupportActionBar(toolbar)

        // reference: https://medium.com/@ermarajhussain/how-to-work-with-navigation-controller-in-android-with-kotlin-part-2-152aa6dc3839
        navController = Navigation.findNavController(this@MainActivity,
            R.id.nav_host_fragment
        )
        appBarConfiguration = AppBarConfiguration(navController.graph,
            drawer_layout)
        NavigationUI.setupWithNavController(toolbar, navController,
            appBarConfiguration)
        NavigationUI.setupActionBarWithNavController(this, navController,
            drawer_layout)
    }

    // Functions to inflate the menu options
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.activity_main_drawer, menu)
        return true
    }

    // navigate to the destination upon selection of a menu item
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
    }

//    override fun onSupportNavigateUp(): Boolean {
//        val navController = findNavController(R.id.nav_host_fragment)
//        return navController.navigateUp()
//    }

}
