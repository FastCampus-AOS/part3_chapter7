package fastcampus.aos.part3.part3_chapter7

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import fastcampus.aos.part3.part3_chapter7.repository.ContentRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val contentRepository: ContentRepository
): ViewModel() {
    val contentList = contentRepository.loadList()
        .stateIn(
            initialValue = emptyList(),
            started = SharingStarted.WhileSubscribed(5000),
            scope = viewModelScope
        )
}