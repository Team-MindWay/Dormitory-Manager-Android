package usecase.auth

import model.auth.response.GAuthLoginResponseModel
import kotlinx.coroutines.flow.Flow
import repository.AuthRepository
import javax.inject.Inject

class TokenRefreshUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
  suspend operator fun invoke(refreshToken: String): Flow<GAuthLoginResponseModel> =
       authRepository.gAuthAccess(refreshToken = "Bearer $refreshToken")
}