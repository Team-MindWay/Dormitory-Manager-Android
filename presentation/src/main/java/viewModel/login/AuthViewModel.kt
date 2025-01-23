package viewmodel.login


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import model.auth.request.GAuthLoginRequestBodyModel
import model.auth.response.GAuthLoginResponseModel
import usecase.auth.GAuthLoginUseCase
import usecase.auth.SaveTokenUseCase
import viewModel.login.uiState.LoginUiState
import viewModel.login.uiState.SaveTokenUiState
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val gAuthLoginUseCase: GAuthLoginUseCase,
    private val saveTokenUseCase: SaveTokenUseCase
) : ViewModel() {
    private val _loginUiState = MutableStateFlow<LoginUiState>(LoginUiState.Loading)
    internal val loginUiState = _loginUiState.asStateFlow()

    private val _saveTokenUiState = MutableStateFlow<SaveTokenUiState>(SaveTokenUiState.Loading)
    internal val saveTokenUiState = _saveTokenUiState.asStateFlow()
    internal fun gAuthLogin(
        code: String,
    ) = viewModelScope.launch {
        _loginUiState.value = LoginUiState.Loading
        gAuthLoginUseCase(GAuthLoginRequestBodyModel(code = code))
            .onSuccess {
                _loginUiState.value = LoginUiState.Success
                it.collect { result ->
                    saveToken(
                        data = result,
                    )
                }
            }.onFailure {
                    exception ->
                _loginUiState.value = LoginUiState.Error(exception)
            }
    }

    private fun saveToken(
        data: GAuthLoginResponseModel,
    ) = viewModelScope.launch {
        _saveTokenUiState.value = SaveTokenUiState.Loading
        saveTokenUseCase(data = data)
            .onSuccess {
                _saveTokenUiState.value = SaveTokenUiState.Success
            }.onFailure { exception ->
                _saveTokenUiState.value = SaveTokenUiState.Error(exception)
            }
    }


}