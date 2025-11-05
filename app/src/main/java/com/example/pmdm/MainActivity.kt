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
import com.example.pmdm.nicolasComponent.Toolbar
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

    val backStackEntry by navController.currentBackStackEntryAsState()

    val bottomRoutes: Set<String> = setOf(
        com.example.pmdm.navigation.Destination.Start.route,
        com.example.pmdm.navigation.Destination.ListContend.route,
        com.example.pmdm.navigation.Destination.Details.route,
        com.example.pmdm.navigation.Destination.Profile.route
    )

    val isBottomRoute: Boolean = if (backStackEntry == null) {
        true
    } else {
        backStackEntry
            ?.destination
            ?.hierarchy
            ?.mapNotNull { it.route }
            ?.any { it in bottomRoutes } == true
    }

    Scaffold(
        topBar = { Toolbar() },
        bottomBar = {
            if (isBottomRoute) {
                com.example.pmdm.nicolasComponent.NavigationBottomBar(navController = navController)
            }
        }
    ) { innerPadding ->
        com.example.pmdm.navigation.AppNavHost(
            navController = navController,
            modifier = Modifier.padding(innerPadding)
        )
    }
}


