package view.Mypage.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable


const val Mypage_loute= "Mypage_loute"

fun NavController.navgationTomypage(){
    this.navigate(Mypage_loute)
}



fun NavGraphBuilder.MainScreen(
    navgationTomypage: () -> Unit
){
    composable(Mypage_loute){
        Mypage_loute(navgationTomypage=navgationTomypage)
    }
}