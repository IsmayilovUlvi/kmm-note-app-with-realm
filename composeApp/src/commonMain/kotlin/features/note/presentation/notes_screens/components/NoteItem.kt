package features.note.presentation.notes_screens.components

import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import features.core.domain.local.model.Note

@Composable
fun NoteItem(
    modifier: Modifier = Modifier,
    note: Note,
    onClick: () -> Unit
) {

    Card(
        modifier = modifier,
        onClick = onClick
    ){

        Text(
            text = note.header
        )

        Text(
            text = note.note
        )


    }

}