package features.core.domain.di

import androidx.lifecycle.ViewModelProvider
import features.core.domain.local.db.AppDb
import features.core.domain.repository.NoteRepository

/**
* @property noteVMFactory does break clean architecture because it belongs AndroidX as visible on import
 * You can add needed dependency in presentation layer like this:
 * val viewModel = viewModel(
 *         modelClass = NoteScreenViewModel::class,
 *         factory = object : ViewModelProvider.Factory{
 *             override fun <T : ViewModel> create(modelClass: KClass<T>, extras: CreationExtras): T {
 *                 return NoteScreenViewModel(
 *                     extras.createSavedStateHandle(),
 *                     AppModuleImpl.noteRepository
 *                 ) as T
 *             }
 *         }
 *     )
 * but 99.9999999% I will note change the viewModel library sine it is an official lib and
 * it does make presentation layer look cluttery(at least to me). it also still provides abstraction for presentation layer
 *
 *
* */

interface AppModule {

    val appDb: AppDb

    val noteRepository: NoteRepository

    val noteVMFactory: ViewModelProvider.Factory
}