package features.note.presentation.notes_screens

import androidx.compose.runtime.Immutable
import features.core.domain.local.model.Note

@Immutable
data class NoteScreenState(
    val searchQuery: String = "",
    val filteredNoteList: List<Note> = emptyList()
)