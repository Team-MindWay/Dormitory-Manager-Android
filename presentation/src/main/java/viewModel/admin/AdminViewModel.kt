package viewmodel.admin

import until.asResult
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import model.admin.request.AdminCleanRequestModel
import model.admin.request.AdminPenaltyRequestModel
import usecase.admin.GetAdminUsersUseCase
import usecase.admin.GetPenaltyListUseCase
import usecase.admin.PostCleanUseCase
import usecase.admin.PostPenaltyUseCase
import viewmodel.admin.uistate.AdminUiState
import viewmodel.admin.uistate.GetPenaltyListUiState
import viewmodel.admin.uistate.GetUserNameUiState
import viewmodel.admin.uistate.GetUserUiState
import viewmodel.admin.uistate.PostCleanUiState
import javax.inject.Inject

class AdminViewModel @Inject constructor(
    private val getAdminUsersUseCase: GetAdminUsersUseCase,
    private val postPenaltyUseCase: PostPenaltyUseCase,
    private val getPenaltyListUseCase: GetPenaltyListUseCase,
    private val postCleanUseCase: PostCleanUseCase
) : ViewModel() {

    private val _adminUiState = MutableStateFlow<AdminUiState>(AdminUiState.Empty)
    val adminUiState: StateFlow<AdminUiState> = _adminUiState.asStateFlow()

    private val _getPenaltyListUiState = MutableStateFlow<GetPenaltyListUiState>(GetPenaltyListUiState.Empty)
    val getPenaltyListUiState: StateFlow<GetPenaltyListUiState> = _getPenaltyListUiState.asStateFlow()

    private val _postCleanUiState = MutableStateFlow<PostCleanUiState>(PostCleanUiState.Empty)
    val postCleanUiState: StateFlow<PostCleanUiState> = _postCleanUiState.asStateFlow()

    private val _getUserNameUiState = MutableStateFlow<GetUserNameUiState>(GetUserNameUiState.Empty)
    val getUserNameUiState: StateFlow<GetUserNameUiState> = _getUserNameUiState.asStateFlow()

    private val _getUserUiState = MutableStateFlow<GetUserUiState>(GetUserUiState.Empty)
    val getUserUiState: StateFlow<GetUserUiState> = _getUserUiState.asStateFlow()


    internal fun getUsers() = viewModelScope.launch {
        getAdminUsersUseCase()
            .asResult()
            .collectLatest { result ->
                when (result) {
                    is until.Result.Success -> {
                        _getUserUiState.value = GetUserUiState.Success(result.data)
                    }

                    is until.Result.Loading -> {
                        _getUserUiState.value = GetUserUiState.Loading
                    }

                    is until.Result.Error -> {
                        _getUserUiState.value = GetUserUiState.Fail
                    }
                }
            }
    }

    internal fun postPenalty(userId: String, body: AdminPenaltyRequestModel) =
        viewModelScope.launch {
            postPenaltyUseCase(
                userId = userId,
                body = body
            )
                .asResult()
                .collectLatest { result ->
                    when (result) {
                        is until.Result.Success -> {
                            _adminUiState.value = AdminUiState.Success(result.data)
                        }

                        is until.Result.Loading -> {
                            _adminUiState.value = AdminUiState.Loading
                        }

                        is until.Result.Error -> {
                            _adminUiState.value = AdminUiState.Fail
                        }

                    }
                }
        }

    internal fun getPenaltyList() = viewModelScope.launch {
        getPenaltyListUseCase()
            .asResult()
            .collectLatest { result ->
                when (result) {
                    is until.Result.Success -> {
                        _getPenaltyListUiState.value = GetPenaltyListUiState.Success(result.data)
                    }

                    is until.Result.Loading -> {
                        _getPenaltyListUiState.value = GetPenaltyListUiState.Loading
                    }

                    is until.Result.Error -> {
                        _getPenaltyListUiState.value = GetPenaltyListUiState.Fail
                    }

                }

            }
    }

    internal fun postClean(userId: String, body: AdminCleanRequestModel) = viewModelScope.launch {
        postCleanUseCase(
            userId = userId,
            body = body
        )
            .asResult()
            .collectLatest { result ->
                when (result) {
                    is until.Result.Success -> {
                        _postCleanUiState.value = PostCleanUiState.Success(result.data)
                    }

                    is until.Result.Loading -> {
                        _postCleanUiState.value = PostCleanUiState.Loading
                    }

                    is until.Result.Error -> {
                        _postCleanUiState.value = PostCleanUiState.Fail
                    }
                }
            }
    }
}