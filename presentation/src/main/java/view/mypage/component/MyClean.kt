package view.mypage.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.kim.presentation.R
import model.users.response.UsersResponseModel
import view.theme.DoMaAndroidTheme
import viewmodel.users.uistate.UsersUiState
import java.util.UUID

@Composable
fun MyClean(
    modifier: Modifier = Modifier,
    usersUiState: UsersUiState,
    onErrorToast: (throwable: Throwable?, message: Int?) -> Unit,
) {
    when (usersUiState) {
        is UsersUiState.Fail -> {
            onErrorToast(usersUiState.exception, R.string.error)
        }

        is UsersUiState.Success -> {
            val data = usersUiState.data
            MyCleanComponent(
                modifier = modifier,
                data = data
            )
        }
        is UsersUiState.Loading -> {

        }
        is UsersUiState.Empty ->{

        }
    }
}

@Composable
fun MyCleanComponent(
    modifier: Modifier = Modifier,
    data: UsersResponseModel,
) {
    DoMaAndroidTheme { colors, typography ->
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start,
        ) {
            Row {
                Text(
                    text = "안녕하세요! ",
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = colors.WHITE
                    )
                )
                Text(
                    text = AnnotatedString.Builder("${data.name}님").apply {
                        addStyle(
                            style = SpanStyle(
                                color = colors.GRAY, fontSize = 20.sp
                            ),
                            start = 0, end = data.name.length
                        )
                    }.toAnnotatedString(),
                    style = TextStyle(
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Black,
                        color = colors.WHITE
                    )
                )
            }
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .background(color = Color(0xFF252525), shape = RoundedCornerShape(size = 10.dp))
                    .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 16.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Top
            ) {

                // 호실
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "호실",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = typography.bodySmall.fontFamily,
                            fontWeight = FontWeight.W500,
                            color = colors.WHITE
                        ),
                        modifier = Modifier.weight(1f)
                    )
                    Text(
                        text = "${data.roomNum}호",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = typography.bodySmall.fontFamily,
                            fontWeight = FontWeight.W500,
                            color = colors.GRAY,
                            textAlign = TextAlign.End
                        ),
                        modifier = Modifier.weight(1f)
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                // 남은 청소
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "남은 청소",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = typography.bodySmall.fontFamily,
                            fontWeight = FontWeight.W500,
                            color = colors.WHITE
                        ),
                        modifier = Modifier.weight(1f)
                    )
                    Text(
                        text = "${data.cleanPoint}회",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = typography.bodySmall.fontFamily,
                            fontWeight = FontWeight.W500,
                            color = colors.GRAY,
                            textAlign = TextAlign.End
                        ),
                        modifier = Modifier.weight(1f)
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                // 벌점
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "벌점",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = typography.bodySmall.fontFamily,
                            fontWeight = FontWeight.W500,
                            color = colors.WHITE
                        ),
                        modifier = Modifier.weight(1f)
                    )
                    Text(
                        text = "${data.penaltyPoint}점",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = typography.bodySmall.fontFamily,
                            fontWeight = FontWeight.W500,
                            color = colors.GRAY,
                            textAlign = TextAlign.End
                        ),
                        modifier = Modifier.weight(1f)
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                // 오늘의 청소
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "오늘의 청소",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = typography.bodySmall.fontFamily,
                            fontWeight = FontWeight.W500,
                            color = colors.WHITE
                        ),
                        modifier = Modifier.weight(1f)
                    )
                    Text(
                        text = "${data.todayClean}학년",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = typography.bodySmall.fontFamily,
                            fontWeight = FontWeight.W500,
                            color = colors.GRAY,
                            textAlign = TextAlign.End
                        ),
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}

@Composable
@Preview
fun preview(){
    MyCleanComponent(
        data = UsersResponseModel(
            because = "dd",
            cleanPoint = 3,
            myBecause = "tktl",
            name = "dd",
            penaltyPoint = 3,
            roomNum = 3,
            todayClean = "오늘",
            userId =UUID.randomUUID(),
            pointList = 3
        )
    )
}