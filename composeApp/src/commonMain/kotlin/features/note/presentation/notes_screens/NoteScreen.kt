package features.note.presentation.notes_screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import features.core.data.di.AppModuleImpl
import features.note.presentation.notes_screens.components.NoteItem
import features.note.presentation.notes_screens.components.NotesTopAppBar

@Composable
fun NoteScreen(
    navController: NavHostController
) {
    val viewModel = viewModel(
        modelClass = NoteScreenViewModel::class,
        factory = AppModuleImpl.noteVMFactory
    )
    val state by viewModel.state.collectAsState()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            NotesTopAppBar(
                searchQuery = state.searchQuery,
                onSearchQueryChange = {
                    viewModel.onEvent(
                        NoteScreenEvent.OnSearchQueryChange(it)
                    )
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    //todo
                }
            ){
                Icon(Icons.Default.Add, contentDescription = null)
            }
        }
    ) { scaffoldPadding ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(scaffoldPadding),
            contentPadding = PaddingValues(16.dp)
        ) {

            items(
                items = state.filteredNoteList,
                key = { it.id!! }
            ){
                NoteItem(
                    modifier = Modifier,
                    note = it,
                    onClick = {}
                )
            }
        }

    }

}