package features.core.domain.local.data_source

import features.core.domain.local.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteDataSource {

    suspend fun insertNote(header: String, note: String): Boolean

    suspend fun updateNote(note: Note): Boolean

    suspend fun deleteNote(note: Note): Boolean

    fun getAllNotesAsFlow(): Flow<List<Note>>
}