package features.core.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import features.note.presentation.notes_screens.NoteScreen

@Composable
fun NavigationHost() {

    val navControlled = rememberNavController()

    NavHost(
        navController = navControlled,
        startDestination = Screens.NotesScreen.route
    ){
        composable(Screens.NotesScreen.route){
            NoteScreen(navControlled)
        }

        composable(Screens.NewNoteScreen.route){

        }
    }

}