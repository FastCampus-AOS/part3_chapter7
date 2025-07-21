package fastcampus.aos.part3.part3_chapter7.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import fastcampus.aos.part3.part3_chapter7.model.ContentEntity

@Dao
interface ContentDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: ContentEntity)
}