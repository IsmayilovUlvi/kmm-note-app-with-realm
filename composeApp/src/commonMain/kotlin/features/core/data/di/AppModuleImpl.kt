@file:Suppress("UNCHECKED_CAST")

package features.core.data.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import features.core.data.local.db.AppDbImpl
import features.core.data.repository.NoteRepositoryImpl
import features.core.domain.di.AppModule
import features.core.domain.local.db.AppDb
import features.core.domain.repository.NoteRepository
import features.note.presentation.notes_screens.NoteScreenViewModel
import kotlin.reflect.KClass

object AppModuleImpl: AppModule {

    override val appDb: AppDb
        by lazy { AppDbImpl.getInstance() }

    override val noteRepository: NoteRepository
       by lazy { NoteRepositoryImpl(appDb) }


    override val noteVMFactory: ViewModelProvider.Factory
        by lazy {
            object : ViewModelProvider.Factory{
                override fun <T : ViewModel> create(
                    modelClass: KClass<T>,
                    extras: CreationExtras
                ): T {
                    return NoteScreenViewModel(
                        savedStateHandle = extras.createSavedStateHandle(),
                        repo = noteRepository
                    ) as T
                }
            }
        }
}