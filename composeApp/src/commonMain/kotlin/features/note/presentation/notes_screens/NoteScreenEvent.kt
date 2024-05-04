package features.note.presentation.notes_screens

sealed interface NoteScreenEvent {
    data class OnSearchQueryChange(val text: String) : NoteScreenEvent
}