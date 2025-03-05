package view.mypage.component

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kim.presentation.R
import model.users.response.UsersResponseModel
import viewmodel.users.uistate.UsersUiState
@Composable
internal fun DemeritList(
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
            DemeritComponent(
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
fun DemeritComponent(
    modifier: Modifier = Modifier,
    data: UsersResponseModel
) {
    var isExpanded by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color = Color(0xFF252525), shape = RoundedCornerShape(size = 10.dp))
            .padding(horizontal = 16.dp, vertical = 12.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "벌점 리스트",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                ),
                modifier = Modifier.weight(1f)
            )


            Icon(
                modifier = Modifier.clickable { isExpanded = !isExpanded },
                painter = painterResource(id = if (isExpanded) R.drawable.down else R.drawable.up),
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
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(2.dp, Alignment.Top),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = stringResource(
                        R.string.stringResource,
                        data.myBecause,
                        data.penaltyPoint
                    ),
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color(0xFFC1C1C1)
                    ),
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
        }
    }
}


