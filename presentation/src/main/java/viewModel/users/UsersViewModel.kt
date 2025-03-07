package viewmodel.users

import until.Result
import until.asResult
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import usecase.Users.GetUsersUseCase
import viewmodel.users.uistate.UsersUiState
import java.util.UUID

import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase,
) : ViewModel() {
    private val _usersUiState = MutableStateFlow<UsersUiState>(UsersUiState.Loading)
    internal val usersUiState = _usersUiState.asStateFlow()

    fun getUsers(userId: UUID) = viewModelScope.launch {
        getUsersUseCase(
            userId = userId
        )
            .asResult()
            .collectLatest { result ->
                when (result) {
                    is Result.Loading -> {
                        _usersUiState.value = UsersUiState.Loading
                    }

                    is Result.Error -> {
                        _usersUiState.value = UsersUiState.Fail(result.exception)
                    }

                    is Result.Success -> {
                        _usersUiState.value = UsersUiState.Success(result.data)
                    }
                }
            }
    }
}