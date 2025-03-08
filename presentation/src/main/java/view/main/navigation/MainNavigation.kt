package view.main.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import view.main.screen.PostDemeritSearchRoute

const val mainRoute = "main_route"
const val demeritPostRoute = "demerit_post_route"
const val studentPatchRoute = "student_patch_route"

fun NavController.navigationToMain() {
    this.navigate(mainRoute)
}

fun NavController.demeritPostRoute(navOptions: NavOptions? = null) {
    this.navigate(demeritPostRoute, navOptions)
}

fun NavGraphBuilder.postDemeritScreen(
    navigateToBack: () -> Unit,
    onErrorToast: (throwable: Throwable?, message: Int?) -> Unit
) {
    composable(demeritPostRoute) {
        PostDemeritSearchRoute(
            navigateToBack = navigateToBack,
            onErrorToast = onErrorToast,
        )
    }
}