package fastcampus.aos.part3.part3_chapter7.repository

import fastcampus.aos.part3.part3_chapter7.data.dao.ContentDao
import fastcampus.aos.part3.part3_chapter7.model.ContentEntity
import javax.inject.Inject

class ContentRepositoryImpl @Inject constructor(
    private val contentDao: ContentDao
): ContentRepository {
    override suspend fun insert(item: ContentEntity) {
        contentDao.insert(item)
    }
}