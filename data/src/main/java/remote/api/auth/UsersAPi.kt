package remote.api.auth

import remote.dto.users.response.UsersResponse
import retrofit2.http.GET

interface UsersAPi {
    @GET("/{user_id}/profile")
    suspend fun getUsers(): List<UsersResponse>







}