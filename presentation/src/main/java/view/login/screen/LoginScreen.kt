package view.login.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.msg.gauthsignin.GAuthSigninWebView
import view.login.component.DoMaGAthButton
import viewModel.login.uiState.LoginUiState
import viewModel.login.uiState.SaveTokenUiState
import viewmodel.login.AuthViewModel

@Composable
internal fun LoginRoute(
    modifier: Modifier = Modifier,
    navigateToHome: () -> Unit,
    authViewModel: AuthViewModel = hiltViewModel(),
) {
    val saveTokenUiState by authViewModel.saveTokenUiState.collectAsStateWithLifecycle()
    val loginUiState by authViewModel.loginUiState.collectAsStateWithLifecycle()
    val (ClickButton, leIsClickLoginButton) = rememberSaveable { mutableStateOf(false) }

    LoginScreen(
        modifier = modifier,
        ClickButton = ClickButton,
        loginUiState = loginUiState,
        saveTokenUiState = saveTokenUiState,
        onErrorToast = { throwable, message ->  },
        navigateToHome = navigateToHome,
        gAuthLogin = { code -> authViewModel.gAuthLogin(code = code)  },
        leIsClickLoginButton = {leIsClickLoginButton(!ClickButton)}

    )
}




@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    ClickButton: Boolean,
    loginUiState: LoginUiState,
    leIsClickLoginButton: () -> Unit,
    gAuthLogin: (String) -> Unit,
    navigateToHome: () -> Unit,
    saveTokenUiState: SaveTokenUiState,
    onErrorToast: (throwable: Throwable?, message: Int?) -> Unit

    ) {

    when (loginUiState) {
        is LoginUiState.Loading -> Unit
        is LoginUiState.Success -> {
            when (saveTokenUiState) {
                is SaveTokenUiState.Success -> {
                    navigateToHome()
                }

                is SaveTokenUiState.Error -> {
                    onErrorToast(saveTokenUiState.exception, 0)
                }

                is SaveTokenUiState.Loading -> Unit
            }
        }

        is LoginUiState.Error -> {
            onErrorToast(loginUiState.exception, 0)

        }
    }
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxSize()
            .background(color = Color(0xFF1E1E1E))
            ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(32.dp, Alignment.Top),
                horizontalAlignment = Alignment.Start
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(40.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "안녕하세요!",
                        style = TextStyle(
                            fontSize = 22.sp,
                            fontWeight = FontWeight(700),
                            color = Color(0xFFFFFFFF),
                            textAlign = TextAlign.Start
                        )
                    )
                    Text(
                        text = AnnotatedString.Builder("로그인을 해볼까요?").apply {
                            addStyle(
                                style = SpanStyle(color = Color(0xFF9BFFA6)), start = 0, end = 3
                            )
                        }.toAnnotatedString(), style = TextStyle(
                            fontSize = 22.sp,
                            fontWeight = FontWeight(900),
                            color = Color(0xFFFFFFFF),
                            textAlign = TextAlign.Start
                        )
                    )

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(
                            10.dp,
                            Alignment.CenterHorizontally
                        ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        DoMaGAthButton(onClick = leIsClickLoginButton)
                    }
                }
                if (ClickButton){
                    GAuthSigninWebView(
                        clientId = "ghskfend",
                        redirectUri = "ghskfen"
                    ){
                        code -> gAuthLogin(code)
                    }
                }
            }
        }
    }


    @Preview
    @Composable
    fun PreviewLoginScreen() {
        LoginScreen(
            ClickButton = false,
            navigateToHome = {},
            onErrorToast = { _, _ -> },
            saveTokenUiState = SaveTokenUiState.Loading,
            loginUiState = LoginUiState.Loading,
            gAuthLogin = {},
            leIsClickLoginButton = {}
        )
    }


