package fastcampus.aos.part3.part3_chapter7

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import fastcampus.aos.part3.part3_chapter7.model.ContentEntity
import fastcampus.aos.part3.part3_chapter7.repository.ContentRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InputViewModel @Inject constructor(
    private val contentRepository: ContentRepository
) : ViewModel(){

    private val _doneEvent = MutableLiveData<Unit>()
    val doneEvent: LiveData<Unit> = _doneEvent

    var content = MutableLiveData<String>()
    var memo = MutableLiveData<String?>()

    fun insertData() {
        content.value?.let { content ->
            viewModelScope.launch(Dispatchers.IO) {
                contentRepository.insert(ContentEntity(content = content, memo = memo.value))
                _doneEvent.postValue(Unit)
            }
        }
    }
}