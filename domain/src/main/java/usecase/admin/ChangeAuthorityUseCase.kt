package usecase.admin

import model.admin.request.AuthorityRequestModel
import reopoistory.AdminRepository
import javax.inject.Inject

class ChangeAuthorityUseCase @Inject constructor(
    private val adminRepository: AdminRepository
) {
    operator fun invoke(body: AuthorityRequestModel)= runCatching {
        adminRepository.changeAuthority(body = body)
    }
}