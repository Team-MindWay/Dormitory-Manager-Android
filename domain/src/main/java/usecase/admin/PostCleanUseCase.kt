package usecase.admin

import model.admin.request.AdminCleanRequestModel
import reopoistory.AdminRepository
import javax.inject.Inject

class PostCleanUseCase @Inject constructor(
    private val adminRepository: AdminRepository

){
    operator fun invoke(userId: String, body: AdminCleanRequestModel) =
        adminRepository.postClean(userId = userId, body = body)
}