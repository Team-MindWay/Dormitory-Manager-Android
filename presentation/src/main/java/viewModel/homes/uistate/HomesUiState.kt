package viewmodel.homes.uistate

import model.rank.response.RankResponseModel

sealed interface HomesUiState {
    object Loading :HomesUiState
    object Empty : HomesUiState
    data class Success(val data: List<RankResponseModel>) : HomesUiState
    data class Fail(val exception: Throwable) : HomesUiState
}