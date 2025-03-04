package component.combinationVIew

import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import component.modifier.DomaNavBar
import emumtype.DomaNavBarItemType
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import view.Mypage.Screen.MyPageRoute
import view.main.Screen.MainRoute
import view.notice.screen.NoticeRoute

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DomaCombinationView(
    modifier: Modifier = Modifier,
    coroutine : CoroutineScope = rememberCoroutineScope(),
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
