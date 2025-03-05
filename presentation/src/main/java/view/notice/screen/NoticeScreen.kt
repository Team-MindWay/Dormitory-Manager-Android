package view.notice.screen

import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import view.notice.component.NoticeList
import view.theme.DoMaAndroidTheme
import viewmodel.homes.HomesViewModel
import viewmodel.homes.uistate.NoticeUiState
import java.util.UUID

@Composable
fun NoticeRoute(
    navigateToBack: () -> Unit,
    viewModel: HomesViewModel = hiltViewModel(LocalContext.current as ComponentActivity),
    onErrorToast: (throwable: Throwable?, message: Int?) -> Unit,
) {
    val noticeUiState by viewModel.noticeUiState.collectAsStateWithLifecycle()

    NoticeScreen(
        noticeUiState = noticeUiState,
        navigateToBack = navigateToBack,
        noticeCallBack = viewModel::getNotice,
        onErrorToast = onErrorToast,
    )
}
@Composable
fun NoticeScreen(
    modifier: Modifier = Modifier,
    noticeUiState: NoticeUiState,
    navigateToBack: () -> Unit,
    noticeCallBack: (UUID) -> Unit,
    onErrorToast: (throwable: Throwable?, message: Int?) -> Unit,
) {
    val scrollState = rememberScrollState()
    var uuid by remember { mutableStateOf(UUID.randomUUID()) }
    LaunchedEffect(Unit) {
        noticeCallBack(uuid)
    }
    DoMaAndroidTheme { colors, typography ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .background(color = Color(0xFF1E1E1E))
        ) {
            Spacer(modifier = Modifier.height(40.dp))
            Text(
                text = "공지사항",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontFamily = typography.titleMedium.fontFamily,
                    fontWeight = FontWeight.Medium,
                    color = colors.WHITE,
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
            )

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
                NoticeList(
                    noticeUiState = noticeUiState,
                    onErrorToast = onErrorToast,
                )
            }
        }
    }
}

@Preview
@Composable
fun NoticeScreenPreview() {
    NoticeScreen(
        noticeUiState = NoticeUiState.Loading,
        onErrorToast = { _, _ -> }
        , navigateToBack = {},
        noticeCallBack = {},
    )
}
