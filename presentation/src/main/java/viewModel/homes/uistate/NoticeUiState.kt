package viewmodel.homes.uistate

import model.rank.response.RankResponseModel
import model.users.response.NoticeResponseModel

sealed interface NoticeUiState {
    object Loading : NoticeUiState
    object Empty : NoticeUiState
    data class Success(val data: List<NoticeResponseModel>) : NoticeUiState
    data class Fail(val exception: Throwable) : NoticeUiState
}