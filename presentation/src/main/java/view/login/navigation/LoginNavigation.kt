package view.login.navigation



import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import view.login.screen.LoginScreen


const val loginRoute = "login_route"

fun NavController.navigateToLogin() {
    this.navigate(loginRoute)
}

fun NavGraphBuilder.loginScreen(
    navigateToHome: () -> Unit
) {
    composable(loginRoute) {
        LoginScreen(
            navigateToHome = navigateToHome
        )
    }
}