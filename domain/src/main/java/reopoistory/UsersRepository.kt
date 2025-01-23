package reopoistory

import kotlinx.coroutines.flow.Flow
import model.users.response.UsersResponseModel

interface UsersRepository {

    suspend fun getUsers(): Flow<List<UsersResponseModel>>
}