package viewmodel.homes

import until.asResult
import until.Result
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import usecase.homes.GetMyRankUseCase
import usecase.homes.GetRankUseCase
import usecase.notice.GetNoticeUseCase
import viewmodel.homes.uistate.HomesMyRankUiState
import viewmodel.homes.uistate.HomesUiState
import viewmodel.homes.uistate.NoticeUiState
import java.util.UUID

import javax.inject.Inject

class HomesViewModel @Inject constructor(
    private val getRankUseCase: GetRankUseCase,
    private val getMyRankUseCase: GetMyRankUseCase,
    private val getNoticeUseCase: GetNoticeUseCase
) : ViewModel() {
    private val _homesUiState = MutableStateFlow<HomesUiState>(HomesUiState.Loading)
    val homesUiState = _homesUiState.asStateFlow()

    private val _homesMyRankUiState = MutableStateFlow<HomesMyRankUiState>(HomesMyRankUiState.Loading)
    val homesMyRankUiState = _homesMyRankUiState.asStateFlow()

    private val _noticeUiState = MutableStateFlow<NoticeUiState>(NoticeUiState.Loading)
    val noticeUiState = _noticeUiState.asStateFlow()


    fun getNotice(noticeId: UUID) = viewModelScope.launch {
        getNoticeUseCase(
            noticeId = noticeId
        )
            .asResult()
            .collectLatest { result ->
                when (result) {
                    is Result.Loading -> {
                        _noticeUiState.value = NoticeUiState.Loading
                    }
                    is Result.Error -> {
                        _noticeUiState.value = NoticeUiState.Fail(result.exception)
                    }
                    is Result.Success -> {
                        _noticeUiState.value = NoticeUiState.Success(result.data)
                    }
                }

                }
    }
    fun getRank() = viewModelScope.launch {
        getRankUseCase()
            .asResult()
            .collectLatest { result ->
                when (result) {
                    is Result.Loading -> {
                        _homesUiState.value = HomesUiState.Loading
                    }

                    is Result.Error -> {
                        _homesUiState.value = HomesUiState.Fail(result.exception)

                    }

                    is Result.Success -> {
                        _homesUiState.value = HomesUiState.Success(result.data)
                    }

                }
            }

    }
    fun getMyRank() = viewModelScope.launch {
        getMyRankUseCase()
            .asResult()
            .collectLatest { result ->
                when (result) {
                    is Result.Loading -> {
                        _homesMyRankUiState.value = HomesMyRankUiState.Loading
                    }

                    is Result.Error -> {
                        _homesMyRankUiState.value = HomesMyRankUiState.Fail(result.exception,null)
                    }

                    is Result.Success -> {
                        _homesMyRankUiState.value = HomesMyRankUiState.Success(result.data)


                    }

                }

            }
    }
}



