package remote.datasource.notice

import kotlinx.coroutines.flow.Flow
import remote.dto.users.response.NoticeResponse
import java.util.UUID

interface NoticeDatasource {
    fun getNotice(noticeId: UUID): Flow<List<NoticeResponse>>
}