package repoistory

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import model.users.response.NoticeResponseModel
import remote.datasource.notice.NoticeDatasource
import remote.dto.users.response.toModel
import reopoistory.NoticeRepository
import java.util.UUID
import javax.inject.Inject

class NoticeRepositoryImpl @Inject constructor(
    private val noticeDatasource: NoticeDatasource
): NoticeRepository
{
    override fun getNotice(noticeId: UUID): Flow<List<NoticeResponseModel>> {
        return noticeDatasource.getNotice(noticeId = noticeId).map {list -> list.map { it.toModel() }  }
    }
}