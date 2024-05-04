package features.core.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavigationHost() {

    val navControlled = rememberNavController()

    NavHost(
        navController = navControlled,
        startDestination = Screens.NotesScreen.route
    ){
        composable(Screens.NotesScreen.route){

        }

        composable(Screens.NewNoteScreen.route){

        }
    }

}