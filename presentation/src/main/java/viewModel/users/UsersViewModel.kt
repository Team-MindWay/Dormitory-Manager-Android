package viewModel.users

import Untill.Result
import Untill.asResult
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import usecase.Users.GetUsersUseCase
import viewModel.UIstate.UsersUiState
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase,
) : ViewModel() {
    private val _usersUiState = MutableStateFlow<UsersUiState>(UsersUiState.Loading)
    internal val usersUiState = _usersUiState.asStateFlow()

    fun getUsers() = viewModelScope.launch {
        getUsersUseCase()
            .asResult()
            .collectLatest { result ->
                when (result) {
                    is Result.Loading -> {
                        _usersUiState.value = UsersUiState.Loading
                    }

                    is Result.Error -> {
                        _usersUiState.value = UsersUiState.Fail
                    }

                    is Result.Success -> {
                        if (result.data.isEmpty()) {
                            _usersUiState.value = UsersUiState.Empty
                        } else {
                            _usersUiState.value = UsersUiState.Success(result.data)
                        }
                    }
                }
            }
    }
}

