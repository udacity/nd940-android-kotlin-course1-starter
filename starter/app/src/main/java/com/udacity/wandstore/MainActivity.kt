package com.udacity.wandstore

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.udacity.wandstore.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bindingUtil =  DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        Timber.plant(Timber.DebugTree())
        val navController = this.findNavController(R.id.myNavHostFragment)
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        val toolbar: Toolbar = bindingUtil.toolbar
        NavigationUI.setupWithNavController(toolbar, navController, appBarConfiguration)
    }
}
