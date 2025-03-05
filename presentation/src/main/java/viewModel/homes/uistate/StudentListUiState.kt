package viewmodel.homes.uistate

import model.admin.response.AdminUserListResponseModel

sealed interface StudentListUiState {
    object Loading :StudentListUiState
    object Empty : StudentListUiState
    data class Success(val data: List<AdminUserListResponseModel>) : StudentListUiState
    data class Fail(val exception: Throwable) : StudentListUiState
}