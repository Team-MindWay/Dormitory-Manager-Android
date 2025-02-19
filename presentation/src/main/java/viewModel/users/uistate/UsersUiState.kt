package viewmodel.users.uistate

import kotlinx.collections.immutable.ImmutableList
import model.users.response.UsersResponseModel

sealed interface UsersUiState {
    object Loading : UsersUiState
    object Empty : UsersUiState
    data class Success(val data: UsersResponseModel) : UsersUiState
    data class Fail(val exception: Throwable) : UsersUiState
}