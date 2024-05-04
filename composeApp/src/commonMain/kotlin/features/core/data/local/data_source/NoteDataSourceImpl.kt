package features.core.data.local.data_source

import features.core.data.local.entity.NoteEntity
import features.core.data.mapper.toNoteModel
import features.core.domain.local.data_source.NoteDataSource
import features.core.domain.local.model.Note
import io.realm.kotlin.Realm
import io.realm.kotlin.UpdatePolicy
import io.realm.kotlin.ext.query
import io.realm.kotlin.types.RealmInstant
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class NoteDataSourceImpl(
    private val realm: Realm
) : NoteDataSource {

    override suspend fun insertNote(header: String, note: String): Boolean {
        return try {
            realm.write {
                val noteEntity = NoteEntity().apply {
                    this.header = header
                    this.note = note
                }

                copyToRealm(noteEntity, UpdatePolicy.ALL)
            }
            true
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }

    override suspend fun updateNote(noteModel: Note): Boolean {
        return try {
            val noteEntity: NoteEntity =
                realm.query<NoteEntity>("id == $0", noteModel.id).find().firstOrNull()!!

            realm.write {
                noteEntity.apply {
                    header = noteModel.header
                    note = noteModel.note
                    modifyDate = RealmInstant.now()
                }

                copyToRealm(noteEntity, UpdatePolicy.ALL)
            }
            true
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }

    override suspend fun deleteNote(note: Note): Boolean {
        return try {
            val noteEntity: NoteEntity =
                realm.query<NoteEntity>("id == $0", note.id).find().firstOrNull()!!
            realm.write {
                delete(noteEntity)
            }
            true
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }

    override fun getAllNotesAsFlow(): Flow<List<Note>> {
        return realm
            .query<NoteEntity>()
            .asFlow()
            .map { result ->
                result.list.toList().map { it.toNoteModel() }
            }
    }
}