package features.note.presentation.notes_screens

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import features.core.data.di.AppModuleImpl

@Composable
fun NoteScreen(
    navController: NavHostController
) {
    val viewModel = viewModel(
        modelClass = NoteScreenViewModel::class,
        factory = AppModuleImpl.noteVMFactory
    )


}