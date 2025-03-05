package view.textfield

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import view.theme.DoMaAndroidTheme
import view.theme.DoMaTypography

const val EMPTY = ""

@Composable
fun DoMaTextField(
    modifier: Modifier = Modifier,
    debounceTime: Long = 300L,
    placeHolder: String = EMPTY,
    readOnly: Boolean = false,
    focusManager: FocusManager = LocalFocusManager.current,
    focusRequester: FocusRequester = FocusRequester(),
    setText: String,
    maxLength: Int = 30, // 최대 글자 수 추가
    isError: Boolean = false, // 에러 상태 추가
    errorMessage: String = "입력값이 올바르지 않습니다.", // 기본 에러 메시지
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default.copy(
        imeAction = ImeAction.Search // 검색에 맞게 기본값 설정
    ),
    keyboardActions: KeyboardActions = KeyboardActions(
        onSearch = {
            focusManager.clearFocus() // 검색 후 키보드 숨기기
        }
    ),
    maxLines: Int = 1,
    singleLine: Boolean = true,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    onValueChange: (String) -> Unit = {},
    onSearchTextChange: (String) -> Unit = {}
) {
    DoMaAndroidTheme { colors, typography ->
        val isFocused = remember { mutableStateOf(false) }

        DisposableEffect(Unit) {
            onDispose {
                focusManager.clearFocus()
            }
        }

        LaunchedEffect(setText) {
            delay(debounceTime)
            onSearchTextChange(setText)
        }

        Column {
            TextField(
                value = setText,
                onValueChange = {
                    if (it.length <= maxLength) { // 최대 글자 수 제한
                        val filteredText = it.filterNot { text -> text.isWhitespace() }
                        onValueChange(filteredText)
                    }
                },
                keyboardOptions = keyboardOptions,
                keyboardActions = keyboardActions,
                placeholder = {
                    Text(
                        text = placeHolder,
                        style = typography.bodySmall,
                        fontWeight = FontWeight.Normal,
                        color = colors.GRAY
                    )
                },
                modifier = modifier
                    .fillMaxWidth()
                    .focusRequester(focusRequester)
                    .border(
                        width = 1.dp,
                        shape = RoundedCornerShape(size = 8.dp),
                        color = if (isError) colors.RED else Color(0xFF4C4C4C),
                    )
                    .background(colors.MAIN)
                    .padding(start = 16.dp, top = 12.dp, end = 16.dp, bottom = 12.dp)
                    .onFocusChanged {
                        isFocused.value = it.isFocused
                    },
                maxLines = maxLines,
                singleLine = singleLine,
                textStyle = typography.bodyMedium,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = colors.MAIN,
                    unfocusedTextColor = colors.MAIN,
                    focusedPlaceholderColor = colors.WHITE,
                    unfocusedPlaceholderColor = colors.WHITE,
                    focusedBorderColor = if (isError) colors.RED else Color.Transparent,
                    unfocusedBorderColor = if (isError) colors.RED else Color.Transparent,
                    cursorColor = colors.Gold
                ),
                readOnly = readOnly,
                visualTransformation = visualTransformation
            )
            if (isError) {
                Text(
                    text = errorMessage,
                    style = DoMaTypography.labelLarge.copy(color = colors.RED)
                )
            }
        }
    }
}

@Preview
@Composable
private fun PreView() {
    DoMaTextField(
        setText = "검색",
        onSearchTextChange = {}
    )
}