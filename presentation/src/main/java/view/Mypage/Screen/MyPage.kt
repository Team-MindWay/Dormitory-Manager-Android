package view.Mypage.Screen

import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import view.Mypage.component.DemeritList
import view.Mypage.component.MyDemeritList
import view.Mypage.component.MyClean
import viewmodel.users.UsersViewModel
import viewmodel.users.uistate.UsersUiState
import java.util.UUID

@Composable
internal fun MyPageRoute(
    modifier: Modifier = Modifier,
    onErrorToast: (throwable: Throwable?, message: Int?) -> Unit,
    viewModel: UsersViewModel = hiltViewModel(LocalContext.current as ComponentActivity),
    navigateToBack: () -> Unit,
) {
    val usersUiState by viewModel.usersUiState.collectAsStateWithLifecycle()

    MyPage(
        modifier = modifier,
        onErrorToast = onErrorToast,
        navigateToBack = navigateToBack,
        usersUiState = usersUiState,
        getUserCallBack = viewModel::getUsers,
    )

}

@Composable
fun MyPage(
    modifier: Modifier = Modifier,
    onErrorToast: (throwable: Throwable?, message: Int?) -> Unit,
    navigateToBack: () -> Unit,
    usersUiState: UsersUiState,
    getUserCallBack: (UUID) -> Unit,
) {
    val scrollState = rememberScrollState()
    var uuid by remember { mutableStateOf(UUID.randomUUID()) }

    LaunchedEffect(Unit) {
        getUserCallBack(uuid)
    }
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .background(color = Color(0xFF1E1E1E))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 20.dp,
                    vertical = 16.dp,
                ),
            verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.Top),
            horizontalAlignment = Alignment.Start,
        ) {
            MyClean(
                usersUiState = usersUiState,
                onErrorToast = onErrorToast,
                modifier = modifier,
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, bottom = 16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.Top),
            horizontalAlignment = Alignment.Start,
        ) {
            MyDemeritList(
                usersUiState = usersUiState,
                onErrorToast = onErrorToast,
                modifier = modifier,
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.Top),
            horizontalAlignment = Alignment.Start,
        ) {
            DemeritList(
                usersUiState = usersUiState,
                onErrorToast = onErrorToast,
            )
        }
    }
}
