package com.example.pmdm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.pmdm.nicolasComponent.NavigationBottomBar
import com.example.pmdm.nicolasComponent.Toolbar // <-- si no tienes Toolbar, quita esta línea y el topBar
import com.example.pmdm.navigation.AppNavHost
import com.example.pmdm.navigation.Destination
import com.example.pmdm.ui.theme.PMDMTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PMDMTheme {
                MainContent()
            }
        }
    }
}

@Composable
private fun MainContent() {
    val navController = rememberNavController()

    // Estado actual (puede ser null en el primer frame)
    val backStackEntry by navController.currentBackStackEntryAsState()

    // Construimos un set de rutas del bottom bar SIN nulos y fijo
    // (así evitamos cualquier "fantasma" en runtime)
    val bottomRoutes: Set<String> = setOf(
        com.example.pmdm.navigation.Destination.Start.route,
        com.example.pmdm.navigation.Destination.ListContend.route,
        com.example.pmdm.navigation.Destination.Details.route,
        com.example.pmdm.navigation.Destination.Profile.route
    )

    // ¿Qué ruta consideramos "actual" para decidir si mostrar la barra?
    // - Si aún no hay backstack (primer frame), asumimos Start.
    // - Si ya hay backstack, usamos jerarquía (soporta grafos anidados/args).
    val isBottomRoute: Boolean = if (backStackEntry == null) {
        // Primer frame: muestra la BottomBar en Start
        true
    } else {
        backStackEntry
            ?.destination
            ?.hierarchy
            ?.mapNotNull { it.route }
            ?.any { it in bottomRoutes } == true
    }

    Scaffold(
        topBar = { Toolbar() }, // si no tienes Toolbar, quita esta línea
        bottomBar = {
            if (isBottomRoute) {
                com.example.pmdm.nicolasComponent.NavigationBottomBar(navController = navController)
            }
        }
    ) { innerPadding ->
        // El NavHost fija SIEMPRE start = Start, así que al primer frame ya pintamos Start.
        com.example.pmdm.navigation.AppNavHost(
            navController = navController,
            modifier = Modifier.padding(innerPadding)
        )
    }
}


