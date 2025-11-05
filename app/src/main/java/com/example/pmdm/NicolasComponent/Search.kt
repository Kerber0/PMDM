import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchToggle(
    modifier: Modifier = Modifier,
    hint: String = "Buscar...",
    results: List<String> = emptyList(),
    onSearch: (String) -> Unit = {},
    onResultClick: (String) -> Unit = {}
) {
    var active by rememberSaveable { mutableStateOf(false) }
    var query by rememberSaveable { mutableStateOf("") }

    Box(modifier = modifier.fillMaxWidth()) {

        // 1) Sólo se ve este botón cuando no está activa la barra
        if (!active) {
            IconButton(
                modifier = Modifier.align(Alignment.CenterEnd),
                onClick = { active = true }
            ) {
                Icon(Icons.Default.Search, contentDescription = "Buscar")
            }
        }

        SearchBar(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .fillMaxWidth(),
            query = query,
            onQueryChange = { query = it },
            onSearch = {
                onSearch(query)
                // Si quieres que se cierre al buscar, descomenta:
                // active = false
            },
            active = active,
            onActiveChange = { active = it },
            placeholder = { Text(hint) },
            leadingIcon = {
                Icon(Icons.Default.Search, contentDescription = null)
            },
            trailingIcon = {
                IconButton(onClick = {
                    if (query.isNotEmpty()) {
                        query = ""
                    } else {
                        active = false
                    }
                }) { Icon(Icons.Default.Close, null) }
            }
        ) {
            Column(Modifier.verticalScroll(rememberScrollState())) {
                results.forEach { r ->
                    ListItem(
                        headlineContent = { Text(r) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                onResultClick(r)
                                query = r
                                active = false
                            }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SearchTogglePreview() {
    MaterialTheme {
        Surface {
            SearchToggle(
                results = listOf("Naruto", "Bleach", "One Piece"),
                onSearch = { /* TODO */ }
            )
        }
    }
}
