package features.core.domain.local.db

import features.core.domain.local.data_source.NoteDataSource

interface AppDb {
    fun noteDao(): NoteDataSource
}