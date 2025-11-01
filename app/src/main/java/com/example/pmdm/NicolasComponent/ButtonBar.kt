package com.example.pmdm.nicolasComponent

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.pmdm.navigation.AppNavHost
import com.example.pmdm.navigation.Destination

@Composable
fun NavigationButtomBar(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val startDestination = Destination.Start
    var selectedIndex by rememberSaveable {
        mutableIntStateOf(Destination.entries.indexOf(startDestination))
    }

    Scaffold(
        modifier = modifier,
        topBar = { Toolbar() },  // Muestra tu top bar definida en Toolbar.kt
        bottomBar = {
            NavigationBar {
                Destination.entries.forEachIndexed { index, destination ->
                    NavigationBarItem(
                        selected = selectedIndex == index,
                        onClick = {
                            navController.navigate(destination.route)
                            selectedIndex = index
                        },
                        icon = { Icon(destination.icon, contentDescription = destination.contentDescription) },
                        label = { Text(destination.label) }
                    )
                }
            }
        }
    ) { innerPadding ->
        // Carga el destino seleccionado dentro del área de contenido
        AppNavHost(
            navController = navController,
            startDestination = startDestination,
            modifier = Modifier.padding(innerPadding)
        )
    }
}
