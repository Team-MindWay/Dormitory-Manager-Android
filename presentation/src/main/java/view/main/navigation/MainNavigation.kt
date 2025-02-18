package view.main.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import view.main.Screen.MainRoute
import view.main.Screen.MainScreen

const val mainRoute = "main_route"

fun  NavController.navigationToMain(){
    this.navigate(mainRoute)
}
fun NavGraphBuilder.mainScreen(
    navigateToBack: () -> Unit,
    onErrorToast: (throwable: Throwable?, message: Int?) -> Unit

){
    composable(mainRoute){
        MainRoute(
            navigateToBack = navigateToBack,
            onErrorToast = onErrorToast
        )
    }
}