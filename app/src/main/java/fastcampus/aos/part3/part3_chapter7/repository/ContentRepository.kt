package fastcampus.aos.part3.part3_chapter7.repository

import fastcampus.aos.part3.part3_chapter7.model.ContentEntity
import kotlinx.coroutines.flow.Flow

interface ContentRepository {

    fun loadList(): Flow<List<ContentEntity>>

    suspend fun insert(item: ContentEntity)

}