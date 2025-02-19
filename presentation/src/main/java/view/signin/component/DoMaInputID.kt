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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import view.theme.DoMaTypography

@Composable
fun DoMaInputID(
    modifier: Modifier = Modifier,
) {
    val idState = remember { mutableStateOf(TextFieldValue("")) } // viewmodel 구현 후 수정 하겠습니다.

    Column(
        modifier = Modifier
    ) {
        Text(
            text = "아이디",
            style = DoMaTypography.bodyMedium.copy(color = Color(0xFFFAFAFA))
        )
        Spacer(
            modifier = Modifier.height(4.dp)
        )
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value =  idState.value,
            onValueChange = { idState.value = it },
            textStyle = DoMaTypography.labelLarge.copy(color = Color.White),
            shape = RoundedCornerShape(12.dp),
            singleLine = true,
            placeholder = {
                Text(
                    text = "아이디를 입력해주세요.",
                    style = DoMaTypography.labelLarge.copy(color = Color(0xFF989898))
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                backgroundColor = Color(0xFF1E1E1E),
                cursorColor = Color.White,
                focusedBorderColor = Color(0xFFB9B9B9),
                unfocusedBorderColor = Color(0xFFB9B9B9)
            )
        )
    }
}

@Preview
@Composable
fun PreviewDoMaInputID() {
    DoMaInputID()
}
