package fastcampus.aos.part3.part3_chapter7.repository

import fastcampus.aos.part3.part3_chapter7.data.dao.ContentDao
import fastcampus.aos.part3.part3_chapter7.model.ContentEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ContentRepositoryImpl @Inject constructor(
    private val contentDao: ContentDao
): ContentRepository {

    override fun loadList(): Flow<List<ContentEntity>> = contentDao.selectAll()

    override suspend fun insert(item: ContentEntity) = contentDao.insert(item)

    override suspend fun modify(item: ContentEntity) = contentDao.insert(item)

}