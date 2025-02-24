package usecase.admin

import model.admin.request.AdminPenaltyRequestModel
import reopoistory.AdminRepository
import javax.inject.Inject

class PostPenaltyUseCase @Inject constructor(
    private val adminRepository: AdminRepository
){
    operator fun invoke(userId: String, body: AdminPenaltyRequestModel) =
        adminRepository.postPenalty(userId = userId, body = body)

}