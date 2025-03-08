package view.signin.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import view.theme.DoMaAndroidTheme
import view.theme.DoMaTypography

@Composable
fun DoMaInputID(
    modifier: Modifier = Modifier,
) {
    val idState = remember { mutableStateOf(TextFieldValue("")) } // viewmodel 구현 후 수정 하겠습니다.

    DoMaAndroidTheme { colors, typography ->

        Column(
            modifier = modifier
        ) {
            Text(
                text = "아이디",
                style = DoMaTypography.bodyMedium.copy(color = colors.WHITE)
            )
            Spacer(
                modifier = Modifier.height(4.dp)
            )
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = idState.value,
                onValueChange = { idState.value = it },
                textStyle = DoMaTypography.labelLarge.copy(color = colors.WHITE),
                shape = RoundedCornerShape(12.dp),
                singleLine = true,
                placeholder = {
                    Text(
                        text = "아이디를 입력해주세요.",
                        style = DoMaTypography.labelLarge.copy(color = colors.silver)
                    )
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    backgroundColor = colors.BACKGROUND,
                    cursorColor = colors.WHITE,
                    focusedBorderColor = colors.GRAY,
                    unfocusedBorderColor = colors.GRAY
                )
            )
        }
    }
}

@Preview
@Composable
fun PreviewDoMaInputID() {
    DoMaInputID()
}