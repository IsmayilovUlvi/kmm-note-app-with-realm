package features.note.presentation.notes_screens

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import features.core.domain.repository.NoteRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn

class NoteScreenViewModel(
    private val savedStateHandle: SavedStateHandle,
    private val repo: NoteRepository
) : ViewModel() {


    private val searchQuery = savedStateHandle.getStateFlow(SEARCH_QUERY,"")

    private val notes = repo.getAllNotesAsFlow()

    val state = combine(searchQuery, notes){ searchQuery, notes ->
        NoteScreenState(
            searchQuery = searchQuery,
            filteredNoteList = notes.filter {
                val searchText = searchQuery.lowercase().trim()

                it.note.lowercase().trim().contains(searchText) ||
                        it.header.lowercase().trim().contains(searchText)
            }
        )
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000L),
        NoteScreenState()
    )

    fun onEvent(event: NoteScreenEvent){
        when(event){
            is NoteScreenEvent.OnSearchQueryChange -> {
                savedStateHandle[SEARCH_QUERY] = event.text
            }
        }
    }

    companion object {
        private const val SEARCH_QUERY = "ns_vm_sq"
    }

}