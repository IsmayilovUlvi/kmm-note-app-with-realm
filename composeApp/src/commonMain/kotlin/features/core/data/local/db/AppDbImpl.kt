package features.core.data.local.db

import features.core.data.local.data_source.NoteDataSourceImpl
import features.core.data.local.entity.NoteEntity
import features.core.domain.local.data_source.NoteDataSource
import features.core.domain.local.db.AppDb
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration

class AppDbImpl(
    private val realm: Realm
): AppDb {

    override fun noteDao(): NoteDataSource {
        return NoteDataSourceImpl(realm)
    }


    companion object {

        private var INSTANCE: AppDbImpl? = null

        fun getInstance():AppDbImpl{
            return INSTANCE ?: createInstance().also {
                INSTANCE = it
            }
        }

        private fun createInstance(): AppDbImpl{
            val realm = Realm.open(
                configuration = RealmConfiguration.Builder(
                    schema = setOf(
                        NoteEntity::class
                    )
                )
                    .deleteRealmIfMigrationNeeded()
                    .build()
            )
            return AppDbImpl(realm)
        }
    }
}