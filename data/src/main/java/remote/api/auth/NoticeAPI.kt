package remote.api.auth

import remote.dto.users.response.NoticeResponse
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.UUID

interface NoticeAPI {
    @GET("/{notice_id}")
    suspend fun getNotice(
        @Path("notice_id") noticeId: UUID,
    ): List<NoticeResponse>
}