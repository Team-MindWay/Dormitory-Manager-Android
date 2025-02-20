package view.signin.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
    ClickButton: Boolean,
    gAuthLogin: (String) -> Unit,
    leIsClickLoginButton: () -> Unit,
) {
    DoMaAndroidTheme { colors, typography ->

        Column(
            modifier = modifier
                .fillMaxSize()
                .background(color = colors.Background)
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
                        text = "아이디",
                        style = DoMaTypography.headlineSmall.copy(color = colors.Green),
                    )
                    Text(
                        text = "와",
                        style = DoMaTypography.headlineSmall.copy(color = colors.WHITE),
                    )
                    Text(
                        text = " 비밀번호",
                        style = DoMaTypography.headlineSmall.copy(color = colors.Green),
                    )
                    Text(
                        text = "를 입력해주세요!",
                        style = DoMaTypography.headlineSmall.copy(color = colors.WHITE),
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                DoMaInputID(
                    modifier = Modifier
                        .fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(12.dp))

                DoMaInputPassword(
                    modifier = Modifier
                        .fillMaxWidth()
                )
            }

            DoMaLoginButton(
                onClick = leIsClickLoginButton,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 30.dp)
            )

            if (ClickButton) {
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
    SignInSubScreen(
        ClickButton = false,
        gAuthLogin = {},
        leIsClickLoginButton = {}
    )
}
