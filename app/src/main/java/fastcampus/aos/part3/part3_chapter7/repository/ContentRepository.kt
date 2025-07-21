package fastcampus.aos.part3.part3_chapter7.repository

import fastcampus.aos.part3.part3_chapter7.model.ContentEntity

interface ContentRepository {

    suspend fun insert(item: ContentEntity)
}