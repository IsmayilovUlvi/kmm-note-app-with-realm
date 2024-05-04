package features.core.data.repository

import features.core.domain.local.db.AppDb
import features.core.domain.local.model.Note
import features.core.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow



class NoteRepositoryImpl(
    private val appDb: AppDb
): NoteRepository {

    override fun getAllNotesAsFlow(): Flow<List<Note>> =
        appDb.noteDao().getAllNotesAsFlow()


    override suspend fun createNote(header: String, note: String) {
        appDb.noteDao().insertNote(header, note)
    }

    override suspend fun updateNote(note: Note) {
        appDb.noteDao().updateNote(note)
    }

    override suspend fun deleteNote(note: Note) {
        appDb.noteDao().deleteNote(note)
    }
}