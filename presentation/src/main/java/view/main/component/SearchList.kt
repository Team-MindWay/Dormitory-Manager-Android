package view.main.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kim.presentation.R
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.toPersistentList
import model.admin.response.AdminUserListResponseModel
import viewmodel.homes.uistate.StudentListUiState
import viewmodel.homes.uistate.StudentSearchUiState


@Composable
internal fun SearchList(
    modifier: Modifier = Modifier,
    searchUiState: StudentSearchUiState,
    studentListUiState: StudentListUiState,
    onErrorToast: (throwable: Throwable?, message: Int?) -> Unit
) {
    when (searchUiState) {
        StudentSearchUiState.Loading -> {
            Text(text = "로딩중")
        }

        is StudentSearchUiState.Success -> {
            val list = searchUiState.data
            SearchListComponent(
                modifier = modifier,
                list = list.toPersistentList()
            )
        }

        is StudentSearchUiState.Error -> {
            onErrorToast(searchUiState.exception, R.string.error)
        }

        StudentSearchUiState.Empty -> {
            Text(text = "검색 결과가 없습니다.")
        }

        StudentSearchUiState.QueryEmpty -> {
            when (studentListUiState) {
                StudentListUiState.Loading -> {
                    Text(text = "로딩중")
                }

                is StudentListUiState.Success -> {
                    val list = studentListUiState.data
                    SearchListComponent(
                        modifier = modifier,
                        list = list.toPersistentList()
                    )
                }

                is StudentListUiState.Fail -> {
                    onErrorToast(studentListUiState.exception, R.string.error)
                }

                StudentListUiState.Empty -> {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(215.dp)
                    ) {
                        SearchEmptyText()
                    }
                }
            }
        }
    }
}

@Composable
fun SearchItem(
    modifier: Modifier = Modifier,
    data: AdminUserListResponseModel
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color = Color(0xFF252525), shape = RoundedCornerShape(size = 10.dp)),
        verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(57.dp)
                .border(
                    width = 1.dp,
                    color = Color(0xFF4C4C4C),
                    shape = RoundedCornerShape(size = 10.dp)
                ),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "${data.roomNum}호",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight(700),
                    color = Color(0xFFFFFFFF),
                )
            )
            Spacer(modifier = Modifier.width(20.dp))
            Text(
                text = data.name,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight(600),
                    color = Color(0xFFFFFFFF),
                )
            )
            Spacer(modifier = Modifier.width(152.dp))
            Text(
                text = "${data.penaltyPoint}점",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight(600),
                    color = Color(0xFFFFFFFF),
                )
            )
        }
    }
}

@Composable
internal fun SearchListComponent(
    modifier: Modifier = Modifier,
    list: PersistentList<AdminUserListResponseModel>,
) {
    Column(modifier = modifier.fillMaxWidth()) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(max = 10_000.dp)
        ) {
            items(
                items = list,
                key = { data ->
                    data.userId
                }
            ) { data ->
                SearchItem(
                    modifier = Modifier.fillMaxWidth(),
                    data = data
                )
            }
        }
    }
}

