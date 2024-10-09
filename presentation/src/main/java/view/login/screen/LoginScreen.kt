package view.login.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import view.login.component.DomaGathbutton


@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,

    navigateToHome: () -> Unit


) {
    var isClicked by remember {
        mutableStateOf(false)
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxSize()
            .background(color = Color(0xFF1E1E1E))
    ) {
        Column(
            Modifier
                .width(320.dp)
                .height(200.dp),
            verticalArrangement = Arrangement.spacedBy(32.dp, Alignment.Top),
            horizontalAlignment = Alignment.Start
        ) {
            Column(

                Modifier
                    .width(187.dp)
                    .height(70.dp),
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
                            style = SpanStyle(color = Color(0xFF9BFFA6)),
                            start = 0,
                            end = 3
                        )
                    }.toAnnotatedString(),
                    style = TextStyle(
                        fontSize = 22.sp,
                        fontWeight = FontWeight(900),
                        color = Color(0xFFFFFFFF),
                        textAlign = TextAlign.Start
                    )
                )

            }


            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically
            ) {
                DomaGathbutton(){
                    isClicked=true }
                Button(
                    onClick = { navigateToHome }
                ){
                    Text(text = "button")
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewLoginScreen() {
    LoginScreen(
        navigateToHome = {}
    )
}

