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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kim.presentation.R
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.toPersistentList
import model.rank.response.RankResponseModel
import viewmodel.homes.uistate.HomesMyRankUiState
import viewmodel.homes.uistate.HomesUiState
import java.util.UUID

@Composable
internal fun RankingList(
    modifier: Modifier = Modifier,
    homeUiState: HomesUiState,
    onErrorToast: (throwable: Throwable?, message: Int?) -> Unit
) {
    when (homeUiState) {
        HomesUiState.Loading -> {
            Text(text = "로딩중")
        }

        is HomesUiState.Success -> {
            val list = homeUiState.data

            RankingListItem(
                modifier = modifier,
                list = list.toPersistentList()
            )
        }

        is HomesUiState.Fail -> {
            onErrorToast(homeUiState.exception, R.string.error)
        }

        is HomesUiState.Empty -> {

        }
    }
}

@Composable
fun RankingComponent(
    modifier: Modifier = Modifier,
    data: RankResponseModel,
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
                text = "${data.rank}위",
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
internal fun RankingListItem(
    modifier: Modifier = Modifier,
    list: PersistentList<RankResponseModel>,

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
                RankingComponent(
                    modifier = Modifier.fillMaxWidth(),
                    data = data
                )
            }
        }
    }
}

@Composable
@Preview
fun PreviewRankingComponent() {
    RankingComponent(
        data = RankResponseModel(
            rank = 3,
            name = "김재관",
            penaltyPoint = 5,
            userId = UUID.randomUUID(),
            roomNum = 3
        )
    )
}