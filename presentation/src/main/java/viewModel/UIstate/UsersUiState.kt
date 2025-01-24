package viewModel.UIstate

import model.users.response.UsersResponseModel

sealed interface UsersUiState {
    object Loading : UsersUiState
    object Empty : UsersUiState
    data class Success(val data: List<UsersResponseModel>) : UsersUiState
    object Fail : UsersUiState
}