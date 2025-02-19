package usecase.admin

import kotlinx.coroutines.flow.Flow
import model.admin.response.AdminPenaltyListResponseModel
import reopoistory.AdminRepository
import javax.inject.Inject

class GetPenaltyListUseCase @Inject constructor(
    private val adminRepository: AdminRepository
) {
    operator fun invoke(): Flow<AdminPenaltyListResponseModel> =
        adminRepository.getPenaltyList()
}