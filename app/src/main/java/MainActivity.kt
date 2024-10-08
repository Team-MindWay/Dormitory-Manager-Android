package com.kim.Dormitorymanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import view.login.navigation.loginRoute
import view.login.screen.LoginScreen


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            DMNavHost(navController = rememberNavController(), startDestination = loginRoute)
        }
    }


}