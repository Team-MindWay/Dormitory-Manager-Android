package reopoistory

import kotlinx.coroutines.flow.Flow
import model.users.response.NoticeResponseModel
import java.util.UUID

interface NoticeRepository {
    fun getNotice(noticeId: UUID): Flow<List<NoticeResponseModel>>
}