package view.main.screen

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
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
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
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshIndicator
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.kim.presentation.R
import emumtype.Authority
import kotlinx.coroutines.delay
import view.main.component.MyRanking
import view.main.component.PostDemeritComponent
import view.main.component.RankingList
import view.main.component.StudentPatch
import view.main.component.TimeComponent
import view.theme.DoMaAndroidTheme
import viewmodel.homes.HomesViewModel
import viewmodel.homes.uistate.HomesMyRankUiState
import viewmodel.homes.uistate.HomesUiState
import viewmodel.login.uistate.TokenRefreshUiState

@Composable
internal fun MainRoute(
    navigateToBack: () -> Unit,
    onDemeritStudentClick: () -> Unit,
    onStudentPatchClick: () -> Unit,
    onErrorToast: (throwable: Throwable?, message: Int?) -> Unit,
    viewModel: HomesViewModel = hiltViewModel(LocalContext.current as ComponentActivity)
) {
    val isRefreshing by viewModel.isRefreshing.collectAsStateWithLifecycle()
    val tokenRefreshUiState by viewModel.tokenRefreshUiState.collectAsStateWithLifecycle()
    val role by viewModel.role.collectAsStateWithLifecycle(initialValue = "")
    val homesUiState by viewModel.homesUiState.collectAsStateWithLifecycle()
    val homesMyRankUiState by viewModel.homesMyRankUiState.collectAsStateWithLifecycle()

    MainScreen(
        role = if (role.isNotBlank()) Authority.valueOf(role) else Authority.ROLE_USER,
        isRefreshing = isRefreshing,
        tokenRefreshCallBack = viewModel::tokenRefresh,
        initTokenRefreshCallBack = viewModel::initTokenRefresh,
        onDemeritStudentClick = onDemeritStudentClick,
        homesUiState = homesUiState,
        myRankCallBack = viewModel::getMyRank,
        rankListCallBack = viewModel::getRank,
        homesMyRankUiState = homesMyRankUiState,
        onErrorToast = onErrorToast,
        navigateToBack = navigateToBack,
        onStudentPatchClick = onStudentPatchClick,
        tokenRefreshUiState = tokenRefreshUiState,
    )
}

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    role: Authority,
    isRefreshing: Boolean,
    tokenRefreshCallBack: () -> Unit,
    initTokenRefreshCallBack: () -> Unit,
    onDemeritStudentClick: () -> Unit,
    tokenRefreshUiState: TokenRefreshUiState,
    homesUiState: HomesUiState,
    myRankCallBack: () -> Unit,
    rankListCallBack: () -> Unit,
    homesMyRankUiState: HomesMyRankUiState,
    onErrorToast: (throwable: Throwable?, message: Int?) -> Unit,
    navigateToBack: () -> Unit,
    onStudentPatchClick: () -> Unit
) {
    LaunchedEffect(Unit) {
        myRankCallBack()
        rankListCallBack()
    }
    DisposableEffect(tokenRefreshUiState) {
        if (tokenRefreshUiState is TokenRefreshUiState.Error) {
            onErrorToast(null, R.string.error)
        }
        onDispose { initTokenRefreshCallBack() }
    }

    val scrollState = rememberScrollState()
    val swipeRefreshState = rememberSwipeRefreshState(isRefreshing = isRefreshing)
    var currentTime by rememberSaveable { mutableStateOf(System.currentTimeMillis()) }
    LaunchedEffect("Time") {
        while (true) {
            delay(1_000L)
            currentTime = System.currentTimeMillis()
        }
    }
    DoMaAndroidTheme { colors, typography ->
        SwipeRefresh(
            state = swipeRefreshState,
            modifier = Modifier.statusBarsPadding(),
            onRefresh = {
                tokenRefreshCallBack()
            },
            indicator = { state, refreshTrigger ->
                SwipeRefreshIndicator(
                    state = state,
                    refreshTriggerDistance = refreshTrigger,
                    backgroundColor = colors.GRAY,
                    contentColor = colors.WHITE
                )
            }
        ) {
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
                            .verticalScroll(scrollState)
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
                        if (role != Authority.ROLE_USER) {
                            Spacer(modifier = Modifier.width(16.dp))
                            PostDemeritComponent(
                                onDemeritStudentClick = onDemeritStudentClick
                            )
                            Spacer(modifier = Modifier.width(16.dp))
                            StudentPatch(
                                onStudentPatchClick = onStudentPatchClick
                            )
                        }
                    }
                }
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
        onDemeritStudentClick = {},
        onStudentPatchClick = {},
        tokenRefreshUiState = TokenRefreshUiState.Loading,
        tokenRefreshCallBack = {},
        initTokenRefreshCallBack = {},
        isRefreshing = false,
        role = Authority.ROLE_USER
    )
}