package component.combinationvIew

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import emumtype.DomaNavBarItemType

const val CombinationViewRoute = "combination_view_route"

fun NavController.navigationToCombinationView() {
    this.navigate(CombinationViewRoute)
}

fun NavGraphBuilder.combinationView(
    currentDestination: DomaNavBarItemType,
    setCurrentDestination: (DomaNavBarItemType) -> Unit,
    navigateToNotice: () -> Unit,
    navigateToBack: () -> Unit,
    onDemeritStudentClick: () -> Unit,
    onStudentPatchClick: ()-> Unit,
    onErrorToast: (throwable: Throwable?, message: Int?) -> Unit,
    navigateToMain: () -> Unit,
    navigateToMyPage: () -> Unit,
    navigateToLogin: () -> Unit,
) {
    composable(CombinationViewRoute) {
        DomaCombinationView(
            currentDestination = currentDestination,
            setCurrentDestination = setCurrentDestination,
            navigateToNotice = navigateToNotice,
            navigateToBack = navigateToBack,
            onDemeritStudentClick = onDemeritStudentClick,
            onStudentPatchClick = onStudentPatchClick,
            onErrorToast = onErrorToast,
            navigateToMain = navigateToMain,
            navigateToMyPage = navigateToMyPage,
            navigateToLogin = navigateToLogin
        )
    }
}