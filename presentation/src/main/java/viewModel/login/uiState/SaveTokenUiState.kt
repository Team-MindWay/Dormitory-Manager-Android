package viewModel.login.uiState

sealed interface SaveTokenUiState {
    object Loading : SaveTokenUiState
    object Success : SaveTokenUiState
    data class Error(val exception: Throwable) : SaveTokenUiState
}