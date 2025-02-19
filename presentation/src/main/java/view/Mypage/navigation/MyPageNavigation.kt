package view.Mypage.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import view.Mypage.Screen.MyPage
import view.Mypage.Screen.MyPageRoute


const val MyPage_loute = "Mypage_loute"

fun NavController.navigationToMyPage() {
    this.navigate(MyPage_loute)
}

fun NavGraphBuilder.MyScreen(
    navigationBack: () -> Unit,
    onErrorToast: (throwable: Throwable?, message: Int?) -> Unit,
) {
    composable(MyPage_loute) {
        MyPageRoute(
            onErrorToast = onErrorToast,
            navigateToBack = navigationBack,
        )
    }
}