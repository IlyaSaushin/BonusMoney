package com.earl.bonusmoney.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.earl.bonusmoney.R
import com.earl.bonusmoney.presentation.base.Keys
import com.earl.bonusmoney.presentation.base.SharedPreferenceManager
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var preferenceManager: SharedPreferenceManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        preferenceManager = SharedPreferenceManager(this)
        // imagine, that user is already authenticated
        preferenceManager.putString(Keys.KEY_API, "TOKEN")
        preferenceManager.putString(Keys.KEY_API_VALUE, "123")
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}