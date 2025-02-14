package viewmodel.admin.uistate

import model.admin.response.AdminPenaltyResponseModel
import model.admin.response.AdminUserListResponseModel


sealed interface AdminUiState {
    object Loading : AdminUiState
    object Empty : AdminUiState
    data class Success(val data: List<AdminPenaltyResponseModel>) : AdminUiState
    object Fail :  AdminUiState
}