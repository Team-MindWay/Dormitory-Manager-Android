package usecase.notice

import kotlinx.coroutines.flow.Flow
import model.rank.response.RankResponseModel
import model.users.response.NoticeResponseModel
import reopoistory.NoticeRepository
import java.util.UUID
import javax.inject.Inject

class GetNoticeUseCase @Inject constructor(
    private val noticeRepository: NoticeRepository
)
{
    operator fun invoke(noticeId: UUID): Flow<List<NoticeResponseModel>> =
        noticeRepository.getNotice(noticeId = noticeId)
}