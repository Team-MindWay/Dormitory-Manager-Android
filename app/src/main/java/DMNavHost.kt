package com.kim.Dormitorymanager


import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import view.login.screen.LoginScreen

@Composable
fun DMNavHost(
    navController: NavHostController,
    startDestination: String
){
    val viewModelStoreOwner= checkNotNull(LocalViewModelStoreOwner.current)

    NavHost(navController = navController,
        startDestination =startDestination ){



    }


}