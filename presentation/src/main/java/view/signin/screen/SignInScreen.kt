package view.signin.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.msg.gauthsignin.GAuthSigninWebView
import view.signin.component.DoMaLoginButton
import view.theme.DoMaAndroidTheme
import view.theme.DoMaTypography

@Composable
fun SignInScreen(
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
        ) {
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp, bottom = 20.dp)
                    .weight(1f),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Bottom
            ) {
                Text(
                    text = "안녕하세요!",
                    style = DoMaTypography.headlineSmall.copy(color = colors.WHITE),
                )
                Text(
                    text = "로그인을 해볼까요?",
                    style = DoMaTypography.headlineSmall.copy(color = colors.Green),
                )
            }

            DoMaLoginButton(
                onClick = leIsClickLoginButton,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 10.dp)
            )

            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
            ) {
                Text(
                    text = "아이디 찾기",
                    style = DoMaTypography.labelLarge.copy(color = colors.WHITE),
                )
                Text(
                    text = "|",
                    style = DoMaTypography.labelLarge.copy(color = colors.WHITE),
                )
                Text(
                    text = "비밀번호 찾기",
                    style = DoMaTypography.labelLarge.copy(color = colors.WHITE),
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,

            ) {
                Text(
                    text = "아직 함께하지 못했다면?",
                    style = DoMaTypography.labelLarge.copy(color = colors.WHITE),
                )

                Spacer(modifier = Modifier.width(4.dp))

                Text(
                    text = "회원가입 하기",
                    modifier = Modifier
                        .clickable { /* TODO: 회원가입 화면으로 이동 */ }
                        .semantics { contentDescription = "회원가입 페이지로 이동" },
                    style = DoMaTypography.labelLarge.copy(color = colors.WHITE),
                    textAlign = TextAlign.Center
                )
            }

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
fun PreviewSignInScreen() {
    SignInScreen(
        ClickButton = false,
        gAuthLogin = {},
        leIsClickLoginButton = {}
    )
}