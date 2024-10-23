package com.kim.Dormitorymanager


import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import view.Mypage.navigation.MyScreen
import view.Mypage.navigation.navgationTomypage
import view.login.navigation.loginScreen
import view.login.screen.LoginScreen

@Composable
fun DMNavHost(
    navController: NavHostController = rememberNavController(),
    startDestination: String
){
    val viewModelStoreOwner= checkNotNull(LocalViewModelStoreOwner.current)

    NavHost(navController = navController,
        startDestination =startDestination ){
        loginScreen (
            navigateToHome = {navController}
        )

        MyScreen(
            navgationTomypage = navController::popBackStack

        )



    }


}