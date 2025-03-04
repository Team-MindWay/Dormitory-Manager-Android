package remote.api.auth

import remote.dto.admin.request.AdminCleanRequest
import remote.dto.admin.request.AdminPenaltyRequest
import remote.dto.admin.request.AuthorityRequest
import remote.dto.admin.response.AdminPenaltyListResponse
import remote.dto.admin.response.AdminPenaltyResponse
import remote.dto.admin.response.AdminUserListResponse
import remote.dto.admin.response.AdminUserResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface AdminAPI {

    @GET("admin/users/list")
    suspend fun getUsers(): List<AdminUserListResponse>

    @PATCH("admin/users/authority")
    suspend fun changeAuthority(
        @Body body: AuthorityRequest
    )

    @GET("admin/users/list")
    suspend fun getStudentSearch(
        @Query("name") name: String,
    ): List<AdminUserListResponse>

    @POST("admin/{user_id}/penalty")
    suspend fun postPenalty(
        @Path("user_id") userId: String,
        @Body body: AdminPenaltyRequest
    ): List<AdminPenaltyResponse>

    @GET("admin/users/penalty-list")
    suspend fun getPenaltyList(): AdminPenaltyListResponse

    @POST("admin/{user_id}/clean")
    suspend fun postClean(
        @Path("user_id") userId: String,
        @Body body: AdminCleanRequest
    ): AdminUserResponse

}