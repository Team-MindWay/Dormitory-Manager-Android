package viewmodel.homes.uistate

import model.myrank.response.MyRankResponseModel

sealed interface HomesMyRankUiState {
    object Loading : HomesMyRankUiState
    object Empty : HomesMyRankUiState
    data class Success(val data: MyRankResponseModel) : HomesMyRankUiState
    data class Fail(val throwable: Throwable?, val message: Int?) : HomesMyRankUiState
}