package features.core.data.mapper

import features.core.data.local.entity.NoteEntity
import features.core.domain.local.model.Note

fun NoteEntity.toNoteModel() = Note(
    id= id,
    header = header,
    note = note,
    creationDate = _id.timestamp.toString(),
    modifyDate = modifyDate.toString()
)