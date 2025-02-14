package viewmodel.homes

import Untill.asResult
import Untill.Result
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import usecase.homes.GetMyRankUseCase
import usecase.homes.GetRankUseCase
import viewmodel.homes.uistate.HomesMyRankUiState
import viewmodel.homes.uistate.HomesUiState

import javax.inject.Inject

class HomesViewModel @Inject constructor(
    private val getRankUseCase: GetRankUseCase,
    private val getMyRankUseCase: GetMyRankUseCase,
) : ViewModel() {
    private val _homesUiState = MutableStateFlow<HomesUiState>(HomesUiState.Loading)
    val homesUiState = _homesUiState.asStateFlow()

    private val _homesMyRankUiState = MutableStateFlow<HomesMyRankUiState>(HomesMyRankUiState.Loading)
    val homesMyRankUiState = _homesMyRankUiState.asStateFlow()


    fun getRank() = viewModelScope.launch {
        getRankUseCase()
            .asResult()
            .collectLatest { result ->
                when (result) {
                    is Result.Loading -> {
                        _homesUiState.value = HomesUiState.Loading
                    }

                    is Result.Error -> {
                        _homesUiState.value = HomesUiState.Fail
                    }

                    is Result.Success -> {
                        _homesUiState.value = HomesUiState.Success(result.data)
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
                        _homesMyRankUiState.value = HomesMyRankUiState.Fail
                    }

                    is Result.Success -> {
                        _homesMyRankUiState.value = HomesMyRankUiState.Success(result.data)


                    }

                }

            }
    }
}



