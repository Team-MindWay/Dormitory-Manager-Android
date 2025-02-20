package view.main.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import view.notice.screen.NoticeRoute

const val noticeRoute = "notice_route"

fun  NavController.navigationToNotice(){
    this.navigate(noticeRoute)
}
fun NavGraphBuilder.noticeScreen(
    navigateToBack: () -> Unit,
    onErrorToast: (throwable: Throwable?, message: Int?) -> Unit

){
    composable(noticeRoute){
        NoticeRoute(
            navigateToBack = navigateToBack,
            onErrorToast = onErrorToast
        )
    }
}