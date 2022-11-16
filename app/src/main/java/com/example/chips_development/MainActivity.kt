package com.example.chips_development

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.replace
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.chips_development.fragments.HelpFragment
import com.example.chips_development.fragments.MainFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {
//    private lateinit var navController: NavController

    private var bottomNavigationMain: BottomNavigationView? = null

    private val testFragment = MainFragment()
    private val studyFragment = HelpFragment()
    private val mainFragment = MainFragment()
    private val shopFragment = HelpFragment()
    private val aboutFragment = MainFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        replaceFragment(mainFragment)

//        val navHostFragment = supportFragmentManager
//            .findFragmentById(R.id.fragmentContainerView) as NavHostFragment
//        navController = navHostFragment.navController
        bottomNavigationMain = findViewById(R.id.bottomNavigationMain)

        bottomNavigationMain?.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.tests -> replaceFragment(testFragment)
                R.id.study -> replaceFragment(studyFragment)
                R.id.main -> replaceFragment(mainFragment)
                R.id.shops -> replaceFragment(shopFragment)
                R.id.about -> replaceFragment(aboutFragment)
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment){
        if(fragment != null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentContainerView, fragment)
            transaction.commit()
        }
    }
}