package viewmodel.login.uistate

import model.auth.response.GAuthLoginResponseModel

sealed interface TokenRefreshUiState {
    object Loading : TokenRefreshUiState
    data class Success(val token: GAuthLoginResponseModel) : TokenRefreshUiState
    data class Error(val exception: Throwable) : TokenRefreshUiState
}