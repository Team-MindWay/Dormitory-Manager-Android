package view.notice.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kim.presentation.R
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.toPersistentList
import model.users.response.NoticeResponseModel
import view.theme.DoMaAndroidTheme
import viewmodel.homes.uistate.NoticeUiState

@Composable
internal fun NoticeList(
    modifier: Modifier = Modifier,
    noticeUiState: NoticeUiState,
    onErrorToast: (throwable: Throwable?, message: Int?) -> Unit,
){
    when(noticeUiState){
        is NoticeUiState.Loading -> {

        }
        is NoticeUiState.Empty -> {

        }
        is NoticeUiState.Success -> {
            val list = noticeUiState.data
            NoticeCard(
                modifier = modifier,
                list = list.toPersistentList()
            )
        }
        is NoticeUiState.Fail -> {
            onErrorToast(noticeUiState.exception, R.string.error)
        }

    }

}


@Composable
private fun NoticeCard(
    modifier: Modifier = Modifier,
    list: PersistentList<NoticeResponseModel>
) {
    Column(modifier = modifier.fillMaxWidth()) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(max = 10_000.dp)
        ) {
            items(
                items = list,
                key = { data -> data.noticeId }
            ) { data ->
                NoticeCardItem(
                    modifier = Modifier.fillMaxWidth(),
                    data = data
                )

            }

        }

    }
}
@Composable
fun NoticeCardItem(
    modifier: Modifier = Modifier,
    data: NoticeResponseModel
) {
    DoMaAndroidTheme { colors, typography ->
        Column(
            modifier = modifier
                .fillMaxWidth()
                .background(Color.DarkGray, shape = RoundedCornerShape(8.dp))
                .padding(12.dp)
        ) {
            Text(
                text = data.title,
                color = colors.WHITE,
                fontFamily = typography.bodySmall.fontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = data.content,
                color = colors.WHITE,
                fontFamily = typography.bodySmall.fontFamily,
                fontSize = 12.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Preview
@Composable
fun NoticeCardPreview() {

}
