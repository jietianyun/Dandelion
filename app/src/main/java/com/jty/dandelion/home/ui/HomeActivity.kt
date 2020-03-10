package com.jty.dandelion.home.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.jty.dandelion.Navigator.FixFragmentNavigator
import com.jty.dandelion.R

class HomeActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val fragment = supportFragmentManager.findFragmentById(R.id.root_nav_graph) ?: return
        val navController = NavHostFragment.findNavController(fragment)
        val fixFragmentNavigator = FixFragmentNavigator(this,supportFragmentManager, fragment.id)
        navController.navigatorProvider.addNavigator(fixFragmentNavigator)
        navController.setGraph(R.navigation.nav_graph)
    }


}
