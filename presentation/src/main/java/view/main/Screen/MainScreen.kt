package view.main.Screen

import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import view.main.component.MyPageButton
import view.main.component.MyRanking
import view.main.component.RankingList
import view.main.component.TimeComponent
import viewmodel.homes.HomesViewModel
import viewmodel.homes.uistate.HomesMyRankUiState
import viewmodel.homes.uistate.HomesUiState

@Composable
internal fun MainRoute(
    navigateToBack: () -> Unit,
    onErrorToast: (throwable: Throwable?, message: Int?) -> Unit,
    viewModel: HomesViewModel = hiltViewModel(LocalContext.current as ComponentActivity)
) {
    val homesUiState by viewModel.homesUiState.collectAsStateWithLifecycle()
    val homesMyRankUiState by viewModel.homesMyRankUiState.collectAsStateWithLifecycle()


    MainScreen(
        homesUiState = homesUiState,
        rankListCallBack = viewModel::getRank,
        homesMyRankUiState = homesMyRankUiState,
        onErrorToast = onErrorToast,
        navigateToBack = navigateToBack,
        myRankCallBack = viewModel::getMyRank,
    )


}

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    homesUiState: HomesUiState,
    myRankCallBack: () -> Unit,
    rankListCallBack: () -> Unit,
    homesMyRankUiState: HomesMyRankUiState,
    onErrorToast: (throwable: Throwable?, message: Int?) -> Unit,
    navigateToBack: () -> Unit

) {
    LaunchedEffect(Unit) {
        myRankCallBack()
        rankListCallBack()
    }


    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color(0xFF1E1E1E)),
        verticalArrangement = Arrangement.spacedBy(24.dp, Alignment.Top),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(horizontal = 10.dp),


            ) {
            TimeComponent()
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, top = 16.dp, end = 20.dp, bottom = 16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.Top),
            horizontalAlignment = Alignment.Start,

            ) {
            MyRanking(
                homesMyRankUiState = homesMyRankUiState,
                onErrorToast = onErrorToast
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.Start),
            verticalAlignment = Alignment.CenterVertically,

            ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = Color(0xFF252525), shape = RoundedCornerShape(size = 10.dp)
                    ),
                verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.Top),

                ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "이번주 랭킹", style = TextStyle(
                            fontSize = 18.sp,
                            fontWeight = FontWeight(700),
                            color = Color(0xFFFFFFFF),
                        )
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 28.dp, top = 12.dp, end = 27.dp, bottom = 4.dp),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically,

                    ) {
                    Text(
                        text = "순위", style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight(600),
                            color = Color(0xFF555555),

                            )
                    )
                    Spacer(modifier = Modifier.width(32.dp))

                    Text(
                        text = "이름", style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight(600),
                            color = Color(0xFF555555),
                        )
                    )
                    Spacer(modifier = Modifier.width(150.dp))
                    Text(
                        text = "횟수", style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight(600),
                            color = Color(0xFF555555),
                        )
                    )
                }
                RankingList(
                    homeUiState = homesUiState,
                    onErrorToast = onErrorToast
                )
            }
        }
    }
}


@Composable
@Preview
fun PreviewMainScreen() {
    MainScreen(
        homesUiState = HomesUiState.Loading,
        rankListCallBack = {},
        homesMyRankUiState = HomesMyRankUiState.Loading,
        onErrorToast = { _, _ -> },
        navigateToBack = {},
        myRankCallBack = {},

    )
}