package remote.api.auth

import remote.dto.users.response.UsersResponse
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.UUID

interface UsersAPi {
    @GET("/{user_id}/profile")
    suspend fun getUsers(
        @Path("user_id") userId: UUID
    ): List<UsersResponse>







}