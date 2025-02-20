package remote.datasource.notice

import kotlinx.coroutines.flow.Flow
import remote.api.auth.NoticeAPI
import remote.dto.users.response.NoticeResponse
import util.performApiRequest
import java.util.UUID
import javax.inject.Inject

class NoticeDataSourceImpl @Inject constructor(
    private val noticeService: NoticeAPI
): NoticeDatasource
{
    override  fun getNotice(noticeId: UUID): Flow<List<NoticeResponse>> =
        performApiRequest { noticeService.getNotice(noticeId = noticeId) }
}