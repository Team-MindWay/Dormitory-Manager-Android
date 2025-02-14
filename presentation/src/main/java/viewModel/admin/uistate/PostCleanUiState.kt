package viewmodel.admin.uistate

import model.admin.response.AdminPenaltyListResponseModel
import model.admin.response.AdminUserResponseModel

sealed interface PostCleanUiState {
    object Loading : PostCleanUiState
    object Empty :PostCleanUiState
    data class Success(val data: AdminUserResponseModel) : PostCleanUiState
    object Fail :  PostCleanUiState
}