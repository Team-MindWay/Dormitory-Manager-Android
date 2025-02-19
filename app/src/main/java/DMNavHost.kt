package com.kim.Dormitorymanager


import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import view.Mypage.navigation.MyScreen
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


        MyScreen(
            navigationBack = navController::popBackStack,
            onErrorToast = { throwable, message ->}
        )
    }
}