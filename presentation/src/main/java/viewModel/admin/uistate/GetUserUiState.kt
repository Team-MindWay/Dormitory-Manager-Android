package viewmodel.admin.uistate

import kotlinx.collections.immutable.ImmutableList
import model.admin.response.AdminPenaltyResponseModel
import model.admin.response.AdminUserListResponseModel
import model.rank.response.RankResponseModel

sealed interface GetUserUiState {
    object Loading : GetUserUiState
    object Empty : GetUserUiState
    data class Success(val data: List<AdminUserListResponseModel>) : GetUserUiState
    object Fail :  GetUserUiState
}