package view.signin.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.msg.gauthsignin.GAuthSigninWebView
import view.signin.component.DoMaInputID
import view.signin.component.DoMaInputPassword
import view.signin.component.DoMaLoginButton
import view.theme.DoMaAndroidTheme
import view.theme.DoMaTypography

@Composable
fun SignInSubScreen(
    modifier: Modifier = Modifier,
    clickButton: Boolean,
    gAuthLogin: (String) -> Unit,
    leIsClickLoginButton: () -> Unit,
    idValue: TextFieldValue,
    onIdValueChange: (TextFieldValue) -> Unit,
    passwordValue: TextFieldValue,
    onPasswordValueChange: (TextFieldValue) -> Unit
) {
    DoMaAndroidTheme { colors, typography ->

        Column(
            modifier = modifier
                .fillMaxSize()
                .background(color = colors.BACKGROUND)
                .padding(horizontal = 20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                verticalArrangement = Arrangement.Center
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Text(
                        text = buildAnnotatedString {
                            listOf("아이디" to colors.GREEN, "와" to colors.WHITE, " 비밀번호" to colors.GREEN, "를 입력해주세요!" to colors.WHITE)
                                .forEach { (text, color) ->
                                    withStyle(style = DoMaTypography.headlineSmall.copy(color = color).toSpanStyle()) {
                                        append(text)
                                    }
                                 }
                        }
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                DoMaInputID(
                    modifier = Modifier.fillMaxWidth(),
                    idValue = idValue,
                    onIdValueChange = onIdValueChange
                    )

                Spacer(modifier = Modifier.height(12.dp))

                DoMaInputPassword(
                    modifier = Modifier.fillMaxWidth(),
                    passwordValue = passwordValue,
                    onPasswordValueChange = onPasswordValueChange
                  )
            }

            DoMaLoginButton(
                onClick = leIsClickLoginButton,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 30.dp)
            )

            if (clickButton) {
                GAuthSigninWebView(
                    clientId = "ghskfend",
                    redirectUri = "ghskfen"
                ) { code ->
                    gAuthLogin(code)
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewSignInSubScreen() {
    val idState = remember { mutableStateOf(TextFieldValue("")) }
    val passwordState = remember { mutableStateOf(TextFieldValue("")) }

    SignInSubScreen(
        clickButton = false,
        gAuthLogin = {},
        leIsClickLoginButton = {},
        idValue = idState.value,
        onIdValueChange = { idState.value = it },
        passwordValue = passwordState.value,
        onPasswordValueChange = { passwordState.value = it }
    )
}