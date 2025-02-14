package viewmodel.admin.uistate

import model.admin.response.AdminPenaltyResponseModel
import model.admin.response.AdminUserListResponseModel

sealed interface GetUserNameUiState {
    object Loading : GetUserNameUiState
    object Empty :GetUserNameUiState
    data class Success(val data: List<AdminUserListResponseModel>) : GetUserNameUiState
    object Fail :  GetUserNameUiState
}