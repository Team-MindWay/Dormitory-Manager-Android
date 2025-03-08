package com.kim.Dormitorymanager


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import view.login.navigation.LoginScreen
import view.login.navigation.navigateToLogin


@Composable
fun DMNavHost(
    navController: NavHostController = rememberNavController(),
    startDestination: String
){
    NavHost(navController = navController,
        startDestination =startDestination ){
        LoginScreen(navigateToHome = navController::navigateToLogin)
    }
}