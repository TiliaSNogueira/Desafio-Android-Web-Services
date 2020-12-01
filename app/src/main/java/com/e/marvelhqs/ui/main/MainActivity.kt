package com.e.marvelhqs.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.e.marvelhqs.R


class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        configuraNavigation()


    }

    private fun configuraNavigation() {
        navController = findNavController(R.id.nav_host_fragment_container)
    }
}