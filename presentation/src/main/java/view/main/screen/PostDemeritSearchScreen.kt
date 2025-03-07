package view.main.screen

import androidx.activity.ComponentActivity
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import component.designsystem.DomaSearchTextField
import component.until.keyboardAsState
import view.main.component.SearchList
import view.theme.DoMaAndroidTheme
import viewmodel.homes.HomesViewModel
import viewmodel.homes.uistate.StudentListUiState
import viewmodel.homes.uistate.StudentSearchUiState


@Composable
internal fun PostDemeritSearchRoute(
    navigateToBack: () -> Unit,
    onErrorToast: (throwable: Throwable?, message: Int?) -> Unit,
    viewModel: HomesViewModel = hiltViewModel(LocalContext.current as ComponentActivity)
) {
    val studentSearch by viewModel.studentListSearch.collectAsStateWithLifecycle()
    val studentListUiState by viewModel.studentListUiState.collectAsStateWithLifecycle()
    val studentSearchUiState by viewModel.studentSearchUiState.collectAsStateWithLifecycle()

    PostDemeritSearchScreen(
        studentSearch = studentSearch,
        navigateToBack = navigateToBack,
        onErrorToast = onErrorToast,
        searchUiState = studentSearchUiState,
        onStudentSearchChange = viewModel::onStudentSearchChange,
        studentSearchCallBack = viewModel::studentSearch,
        studentListUiState = studentListUiState,
    )
}

@Composable
fun PostDemeritSearchScreen(
    modifier: Modifier = Modifier,
    studentSearch: String,
    onStudentSearchChange: (String) -> Unit,
    navigateToBack: () -> Unit,
    studentSearchCallBack: (name: String) -> Unit,
    onErrorToast: (throwable: Throwable?, message: Int?) -> Unit,
    searchUiState: StudentSearchUiState,
    studentListUiState: StudentListUiState,
) {

    val scrollState = rememberScrollState()
    val focusManager = LocalFocusManager.current
    val isKeyboardOpen by keyboardAsState()

    LaunchedEffect(isKeyboardOpen) {
        if (!isKeyboardOpen) {
            focusManager.clearFocus()
        }
    }
    DoMaAndroidTheme { colors, typography ->

        Column(
            modifier = modifier
                .verticalScroll(scrollState)
                .pointerInput(Unit) {
                    detectTapGestures {
                        focusManager.clearFocus()
                    }
                }
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DomaSearchTextField(
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                setText = studentSearch,
                placeHolder = "방 호수, 이름 학년등을 검색해보세요",
                singleLine = true,
                onValueChange = onStudentSearchChange,
                onSearchTextChange = studentSearchCallBack,
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 28.dp, top = 12.dp, end = 27.dp, bottom = 4.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            ) {

            Text(
                text = "호수",
                style= typography.labelLarge,
                color = colors.LIGHTGRAY
            )

            Spacer(modifier = Modifier.width(32.dp))

            Text(
                text = "이름",
                style= typography.labelLarge,
                color = colors.LIGHTGRAY
            )
            Spacer(modifier = Modifier.width(150.dp))

            Text(
                text = "점수",
                style= typography.labelLarge,
                color = colors.LIGHTGRAY
            )
        }

        SearchList(
            searchUiState = searchUiState,
            studentListUiState = studentListUiState,
            onErrorToast = onErrorToast
        )
    }
}
