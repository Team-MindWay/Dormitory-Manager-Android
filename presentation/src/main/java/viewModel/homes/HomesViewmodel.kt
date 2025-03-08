package viewmodel.homes

import until.asResult
import until.Result
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import model.admin.request.AuthorityRequestModel
import model.auth.response.GAuthLoginResponseModel
import repository.AuthRepository
import usecase.admin.ChangeAuthorityUseCase
import usecase.admin.GetAdminUsersUseCase
import usecase.admin.GetStudentSearchUseCase
import usecase.auth.SaveTokenUseCase
import usecase.auth.TokenRefreshUseCase
import usecase.homes.GetMyRankUseCase
import usecase.homes.GetRankUseCase
import usecase.notice.GetNoticeUseCase
import viewmodel.homes.uistate.HomesMyRankUiState
import viewmodel.homes.uistate.HomesUiState
import viewmodel.homes.uistate.NoticeUiState
import viewmodel.homes.uistate.StudentListUiState
import viewmodel.homes.uistate.StudentSearchUiState
import viewmodel.login.uistate.SaveTokenUiState
import viewmodel.login.uistate.TokenRefreshUiState
import java.util.UUID

import javax.inject.Inject

class HomesViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val saveTokenUseCase: SaveTokenUseCase,
    private val getRankUseCase: GetRankUseCase,
    private val getMyRankUseCase: GetMyRankUseCase,
    private val getStudentSearchUseCase: GetStudentSearchUseCase,
    private val authRepository: AuthRepository,
    private val getAdminUsersUseCase: GetAdminUsersUseCase,
    private val getNoticeUseCase: GetNoticeUseCase,
    private val tokenRefreshUseCase: TokenRefreshUseCase,
    private val changeAuthorityUseCase: ChangeAuthorityUseCase
) : ViewModel() {

    private val _changeAuthorityUiState = MutableStateFlow<Result<Unit>>(Result.Loading)
    internal val changeAuthorityUiState = _changeAuthorityUiState.asStateFlow()

    private val _isRefreshing = MutableStateFlow(false)
    internal val isRefreshing = _isRefreshing.asStateFlow()

    private val _tokenRefreshUiState =
        MutableStateFlow<TokenRefreshUiState>(TokenRefreshUiState.Loading)
    internal val tokenRefreshUiState = _tokenRefreshUiState.asStateFlow()

    private val _saveTokenUiState = MutableStateFlow<SaveTokenUiState>(SaveTokenUiState.Loading)
    internal val saveTokenUiState = _saveTokenUiState.asStateFlow()

    internal var role = authRepository.getRole()
    private var refreshToken = runBlocking { authRepository.getRefreshToken().first() }

    private val _homesUiState = MutableStateFlow<HomesUiState>(HomesUiState.Loading)
    val homesUiState = _homesUiState.asStateFlow()

    private val _studentSearchUiState = MutableStateFlow<StudentSearchUiState>(StudentSearchUiState.Loading)
    internal val studentSearchUiState = _studentSearchUiState.asStateFlow()

    private val _studentListUiState = MutableStateFlow<StudentListUiState>(StudentListUiState.Loading)
    internal val studentListUiState = _studentListUiState.asStateFlow()

    private val _homesMyRankUiState = MutableStateFlow<HomesMyRankUiState>(HomesMyRankUiState.Loading)
    val homesMyRankUiState = _homesMyRankUiState.asStateFlow()

    private val _noticeUiState = MutableStateFlow<NoticeUiState>(NoticeUiState.Loading)
    val noticeUiState = _noticeUiState.asStateFlow()

    internal var roleState = savedStateHandle.getStateFlow(key = ROLE_STATE, initialValue = "")
    internal var studentListSearch = savedStateHandle.getStateFlow(key = STUDENT_SEARCH, initialValue = "")

    internal fun tokenRefresh() = viewModelScope.launch {
        _isRefreshing.value = true
        delay(1_000L)
        refreshToken = runBlocking { authRepository.getRefreshToken().first() }
        tokenRefreshUseCase(refreshToken = "Bearer ${refreshToken}")
            .asResult()
            .collectLatest { result ->
                when (result) {
                    is Result.Loading -> _tokenRefreshUiState.value = TokenRefreshUiState.Loading
                    is Result.Success -> {
                        _tokenRefreshUiState.value = TokenRefreshUiState.Success(result.data)
                        saveToken(data = result.data)
                    }

                    is Result.Error -> {
                        _tokenRefreshUiState.value = TokenRefreshUiState.Error(result.exception)
                        _isRefreshing.value = false
                    }
                }
            }
    }

    internal fun changeAuthority(body: AuthorityRequestModel) = viewModelScope.launch {
        changeAuthorityUseCase(body = body)
            .onSuccess {
                it.catch { remoteError ->
                    _changeAuthorityUiState.value = Result.Error(remoteError)
                }.collect { result ->
                    _changeAuthorityUiState.value = Result.Success(result)
                }
            }.onFailure {
                _changeAuthorityUiState.value = Result.Error(it)
            }
    }

    internal fun initTokenRefresh() {
        _tokenRefreshUiState.value = TokenRefreshUiState.Loading
    }

    private fun saveToken(data: GAuthLoginResponseModel) = viewModelScope.launch {
        _saveTokenUiState.value = SaveTokenUiState.Loading
        saveTokenUseCase(data = data)
            .onSuccess {
                _saveTokenUiState.value = SaveTokenUiState.Success
                role = authRepository.getRole()
                refreshToken = runBlocking { authRepository.getRefreshToken().first() }
                _isRefreshing.value = false
            }
            .onFailure {
                _saveTokenUiState.value = SaveTokenUiState.Error(it)
                _isRefreshing.value = false
            }
    }

    fun getNotice(noticeId: UUID) = viewModelScope.launch {
        getNoticeUseCase(
            noticeId = noticeId
        )
            .asResult()
            .collectLatest { result ->
                when (result) {
                    is Result.Loading -> {
                        _noticeUiState.value = NoticeUiState.Loading
                    }

                    is Result.Error -> {
                        _noticeUiState.value = NoticeUiState.Fail(result.exception)
                    }

                    is Result.Success -> {
                        _noticeUiState.value = NoticeUiState.Success(result.data)
                    }
                }
            }
    }

    fun getRank() = viewModelScope.launch {
        getRankUseCase()
            .asResult()
            .collectLatest { result ->
                when (result) {
                    is Result.Loading -> {
                        _homesUiState.value = HomesUiState.Loading
                    }

                    is Result.Error -> {
                        _homesUiState.value = HomesUiState.Fail(result.exception)

                    }

                    is Result.Success -> {
                        _homesUiState.value = HomesUiState.Success(result.data)
                    }

                }
            }
    }

    internal fun studentSearch(name: String) = viewModelScope.launch {
        if (name.isEmpty()) {
            _studentSearchUiState.value = StudentSearchUiState.QueryEmpty
        } else {
            getStudentSearchUseCase(
                name = name,
            )
                .asResult()
                .collectLatest { result ->
                    when (result) {
                        is Result.Loading -> {
                            _studentSearchUiState.value = StudentSearchUiState.Loading
                        }

                        is Result.Error -> {
                            _studentSearchUiState.value =
                                StudentSearchUiState.Error(result.exception)
                        }

                        is Result.Success -> {
                            if (result.data.isEmpty()) {
                                _studentSearchUiState.value = StudentSearchUiState.Loading
                                _studentSearchUiState.value =
                                    StudentSearchUiState.Success(result.data)
                            }
                        }
                    }
                }
        }
    }

    private fun getStudentList() = viewModelScope.launch {
        getAdminUsersUseCase()
            .asResult()
            .collectLatest { result ->
                when (result) {
                    is Result.Loading -> {
                        _studentListUiState.value = StudentListUiState.Loading
                    }

                    is Result.Error -> {
                        _studentListUiState.value = StudentListUiState.Fail(result.exception)
                    }

                    is Result.Success -> {
                        _studentListUiState.value = StudentListUiState.Success(result.data)
                    }
                }
            }
    }

    fun getMyRank() = viewModelScope.launch {
        getMyRankUseCase()
            .asResult()
            .collectLatest { result ->
                when (result) {
                    is Result.Loading -> {
                        _homesMyRankUiState.value = HomesMyRankUiState.Loading
                    }

                    is Result.Error -> {
                        _homesMyRankUiState.value = HomesMyRankUiState.Fail(result.exception, null)
                    }

                    is Result.Success -> {
                        _homesMyRankUiState.value = HomesMyRankUiState.Success(result.data)

                    }
                }
            }
    }

    internal fun onStudentSearchChange(value: String) {
        savedStateHandle[STUDENT_SEARCH] = value
    }
}

private const val STUDENT_SEARCH = "student search"
private const val ROLE_STATE = "role state"

