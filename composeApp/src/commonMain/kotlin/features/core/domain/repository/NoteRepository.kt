package features.core.domain.repository

import features.core.domain.local.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    fun getAllNotesAsFlow() : Flow<List<Note>>

    suspend fun createNote(header: String, note: String)
    suspend fun updateNote(note: Note)
    suspend fun deleteNote(note: Note)
}