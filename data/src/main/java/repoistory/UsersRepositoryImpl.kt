package repoistory

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import model.users.response.UsersResponseModel
import remote.datasource.users.UsersDataSource
import remote.dto.users.response.toModel
import reopoistory.UsersRepository
import java.util.UUID
import javax.inject.Inject

class UsersRepositoryImpl @Inject constructor(
    private val usersDataSource: UsersDataSource
): UsersRepository {

    override suspend fun getUsers(userId: UUID): Flow<UsersResponseModel> {
        return usersDataSource.getUsers(userId = userId).map { it.toModel() } }
    }
