package view.mypage.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.runtime.Composable
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kim.presentation.R
import model.users.response.UsersResponseModel
import viewmodel.users.uistate.UsersUiState
import java.util.UUID
@Composable
internal fun MyDemeritList(
    modifier: Modifier = Modifier,
    usersUiState: UsersUiState,
    onErrorToast: (throwable: Throwable?, message: Int?) -> Unit,
){
    when (usersUiState) {
        is UsersUiState.Fail -> {
            onErrorToast(usersUiState.exception, R.string.error)
        }

        is UsersUiState.Success -> {
            val data = usersUiState.data
            MyDemeritComponent(
                modifier = modifier,
                data = data
            )
        }
        is UsersUiState.Empty ->{

        }
        is UsersUiState.Loading -> {

        }
    }
}

@Composable
fun MyDemeritComponent(
    modifier: Modifier = Modifier,
    data: UsersResponseModel
) {
    var isExpanded by remember { mutableStateOf(false) } // 펼쳐짐 상태 관리

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color = Color(0xFF252525), shape = RoundedCornerShape(size = 10.dp))
            .padding(horizontal = 16.dp, vertical = 12.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "나의 벌점 내역",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                ),
                modifier = Modifier.weight(1f)
            )
            Icon(
                modifier = Modifier
                    .clickable { isExpanded = !isExpanded },
                painter = painterResource(id = if (isExpanded) R.drawable.up else R.drawable.down),
                contentDescription = "Expand Toggle",

                tint = Color.White
            )
        }

        AnimatedVisibility(
            visible = isExpanded,
            enter = expandVertically() + fadeIn(),
            exit = shrinkVertically() + fadeOut()
        ) {
            Column(
                modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
                verticalArrangement = Arrangement.spacedBy(2.dp, Alignment.Top),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = stringResource(
                        R.string.DemeritList,
                        data.myBecause,
                        data.pointList
                    ),
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color(0xFFD4D4D4)
                    )
                )
            }
        }
    }
}

@Composable
@Preview
fun PreviewMyDemeritComponent() {
    MyDemeritComponent(
        data = UsersResponseModel(
            penaltyPoint = 3,
            myBecause = "청소",
            because = "청소",
            cleanPoint = 0,
            todayClean = "호날두",
            roomNum = 0,
            name = "김재관",
            userId = UUID.randomUUID(),
            pointList = 3
        )
    )
}
