package repoistory

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import model.users.response.UsersResponseModel
import remote.datasource.users.UsersDataSource
import remote.dto.users.response.toModel
import reopoistory.UsersRepository
import javax.inject.Inject

class UsersRepositoryImpl @Inject constructor(
    private val usersDataSource: UsersDataSource
): UsersRepository {

    override suspend fun getUsers(): Flow<List<UsersResponseModel>> {
        return usersDataSource.getUsers().map { list -> list.map { it.toModel() } }
    }
}