package component.combinationvIew

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import component.navigationbar.DomaNavBar
import emumtype.DomaNavBarItemType
import view.mypage.Screen.MyPageRoute
import view.main.screen.MainRoute
import view.notice.screen.NoticeRoute

@Composable
fun DomaCombinationView(
    modifier: Modifier = Modifier,
    currentDestination: DomaNavBarItemType,
    setCurrentDestination: (DomaNavBarItemType) -> Unit,
    navigateToNotice: () -> Unit,
    navigateToMain: () -> Unit,
    navigateToMyPage: () -> Unit,
    navigateToLogin: () -> Unit,
    navigateToBack: () -> Unit,
    onDemeritStudentClick: () -> Unit,
    onStudentPatchClick: ()-> Unit,
    onErrorToast: (throwable: Throwable?, message: Int?) -> Unit

) {
    Scaffold(
        bottomBar = {
            DomaNavBar(
                currentDestination = currentDestination,
                setCurrentDestination = setCurrentDestination,
            )
        }
    ) { padding->
        Box(modifier = modifier.padding(padding)) {
            when (currentDestination) {
                DomaNavBarItemType.HOME -> MainRoute(
                    navigateToBack = navigateToBack,
                    onDemeritStudentClick = onDemeritStudentClick,
                    onStudentPatchClick = onStudentPatchClick,
                    onErrorToast = onErrorToast
                )

                DomaNavBarItemType.Notice-> NoticeRoute(
                    navigateToBack = navigateToBack,
                    onErrorToast = onErrorToast
                )

                DomaNavBarItemType.MY-> MyPageRoute(
                    onErrorToast = onErrorToast,
                    navigateToBack = navigateToBack
                )
            }
        }
    }
}
