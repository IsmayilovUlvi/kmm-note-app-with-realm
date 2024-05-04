package features.note.presentation.notes_screens

import features.core.domain.local.model.Note

data class NoteScreenState(
    val searchQuery: String = "",
    val filteredNoteList: List<Note> = emptyList()
)