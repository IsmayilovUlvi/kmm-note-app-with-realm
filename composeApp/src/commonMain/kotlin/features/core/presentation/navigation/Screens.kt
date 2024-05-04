package features.core.presentation.navigation

sealed class Screens(val name: String, val route: String) {

    data object NotesScreen: Screens("Notes", "/notes")
    data object NewNoteScreen: Screens("New Note", "/new_note")

}