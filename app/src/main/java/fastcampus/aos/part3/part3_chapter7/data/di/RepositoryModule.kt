package fastcampus.aos.part3.part3_chapter7.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import fastcampus.aos.part3.part3_chapter7.data.dao.ContentDao
import fastcampus.aos.part3.part3_chapter7.repository.ContentRepository
import fastcampus.aos.part3.part3_chapter7.repository.ContentRepositoryImpl

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    @ViewModelScoped
    fun providesContentRepository(contentDao: ContentDao): ContentRepository = ContentRepositoryImpl(contentDao)
}