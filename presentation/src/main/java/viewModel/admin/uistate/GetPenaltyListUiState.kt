package viewmodel.admin.uistate

import model.admin.response.AdminPenaltyListResponseModel

sealed interface GetPenaltyListUiState {
    object Loading : GetPenaltyListUiState
    object Empty : GetPenaltyListUiState
    data class Success(val data: AdminPenaltyListResponseModel) : GetPenaltyListUiState
    object Fail :  GetPenaltyListUiState
}