package viewmodel.homes.uistate

import model.admin.response.AdminUserListResponseModel

sealed interface StudentSearchUiState {
    object Loading : StudentSearchUiState
    object Empty : StudentSearchUiState
    object QueryEmpty : StudentSearchUiState
    data class Success(val data: List<AdminUserListResponseModel>) : StudentSearchUiState
    data class Error(val exception: Throwable) : StudentSearchUiState
}