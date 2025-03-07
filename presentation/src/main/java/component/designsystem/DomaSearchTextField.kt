package component.designsystem

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
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import component.modifier.SerchIcon
import kotlinx.coroutines.delay
import view.theme.DoMaAndroidTheme

const val EMPTY = ""

@Composable
fun DomaSearchTextField(
    modifier: Modifier = Modifier,
    debounceTime: Long = 300L,
    placeHolder: String = EMPTY,
    readOnly: Boolean = false,
    focusManager: FocusManager = LocalFocusManager.current,
    focusRequester: FocusRequester = FocusRequester(),
    setText: String,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    maxLines: Int = Int.MAX_VALUE,
    singleLine: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    onValueChange: (String) -> Unit = {},
    onSearchTextChange: (String) -> Unit = { }
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
                    val filteredText = it.filterNot { text -> text.isWhitespace() }
                    onValueChange(filteredText)
                },
                keyboardOptions = keyboardOptions,
                keyboardActions = keyboardActions,
                placeholder = {
                    Text(
                        text = placeHolder,
                        style = typography.bodySmall,
                        fontWeight = FontWeight.Normal,
                        color = colors.DARKGARY
                    )
                },
                modifier = modifier
                    .fillMaxWidth()
                    .focusRequester(focusRequester)
                    .border(
                        width = 1.dp,
                        color = colors.SMAlLDARKGARY,
                        shape = RoundedCornerShape(size = 8.dp)
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
                focusedPlaceholderColor = colors.DARKGARY,
                unfocusedPlaceholderColor = colors.DARKGARY,
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
                cursorColor = colors.Gold
            ),
            trailingIcon = {
                SerchIcon(
                    tint = colors.DARKGARY
                )
            },
            readOnly = readOnly,
            visualTransformation = visualTransformation
            )
        }
    }
}

@Preview
@Composable
private fun PreView() {
    DomaSearchTextField(
        setText = "검색",
        onSearchTextChange = { },
    )
}
