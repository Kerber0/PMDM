package com.example.pmdm.nicolasComponent

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.pmdm.navigation.Destination

@Composable
fun NavigationBottomBar(
    navController: NavController,
    selectedIndex: Int,
    onItemSelected: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    NavigationBar(modifier = modifier) {
        Destination.entries.forEachIndexed { index, destination ->
            NavigationBarItem(
                selected = selectedIndex == index,
                onClick = {
                    navController.navigate(destination.route)
                    onItemSelected(index)
                },
                icon = { Icon(destination.icon, contentDescription = destination.contentDescription) },
                label = { Text(destination.label) }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewNavigationBottomBar() {
    var selectedIndex by remember {
        mutableStateOf(Destination.entries.indexOf(Destination.Start))
    }

    // Construimos la barra manualmente, sin navController
    NavigationBar {
        Destination.entries.forEachIndexed { index, destination ->
            NavigationBarItem(
                selected = selectedIndex == index,
                onClick = { selectedIndex = index },
                icon = { Icon(destination.icon, contentDescription = destination.contentDescription) },
                label = { Text(destination.label) }
            )
        }
    }
}


