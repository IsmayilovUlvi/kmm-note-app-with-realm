package features.core.presentation

import androidx.compose.runtime.Composable
import features.core.presentation.navigation.NavigationHost
import features.core.presentation.ui.theme.AppTheme
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalResourceApi::class)
@Composable
@Preview
fun App() {
    AppTheme {
        NavigationHost()
    }
}