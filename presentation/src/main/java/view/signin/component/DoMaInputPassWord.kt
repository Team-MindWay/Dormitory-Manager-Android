
package view.signin.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import view.theme.DoMaAndroidTheme
import view.theme.DoMaTypography
import view.theme.color.DoMaColor

@Composable
fun DoMaInputPassword(
    modifier: Modifier = Modifier,
) {
    val passwordState = remember { mutableStateOf(TextFieldValue("")) } // viewmodel 구현 후 수정 하겠습니다.

    DoMaAndroidTheme { colors, typography ->

        Column(
            modifier = modifier
        ) {
            Text(
                text = "비밀번호",
                style = DoMaTypography.bodyMedium.copy(color = colors.WHITE)
            )
            Spacer(
                modifier = Modifier.height(4.dp)
            )
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = passwordState.value,
                onValueChange = { passwordState.value = it },
                textStyle = DoMaTypography.labelLarge.copy(color = colors.WHITE),
                shape = RoundedCornerShape(12.dp),
                singleLine = true,
                placeholder = {
                    Text(
                        text = "비밀번호를 입력해주세요.",
                        style = DoMaTypography.labelLarge.copy(color = colors.silver)
                    )
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    backgroundColor = DoMaColor.BACKGROUND,
                    cursorColor = DoMaColor.WHITE,
                    focusedBorderColor = DoMaColor.silver,
                    unfocusedBorderColor = DoMaColor.silver
                )
            )
        }
    }
}

@Preview
@Composable
fun PreviewDoMaInputPassword() {
    DoMaInputPassword()
}
