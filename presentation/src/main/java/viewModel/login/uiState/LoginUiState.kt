package viewmodel.login.uistate

sealed interface LoginUiState {
    object Loading : LoginUiState
    object Success : LoginUiState
    data class Error(val exception: Throwable) : LoginUiState
}