package usecase.Users

import kotlinx.coroutines.flow.Flow
import model.users.response.UsersResponseModel
import reopoistory.UsersRepository
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(
    private val usersRepository: UsersRepository
){
    suspend operator fun invoke(): Flow<List<UsersResponseModel>> =
        usersRepository.getUsers()
}