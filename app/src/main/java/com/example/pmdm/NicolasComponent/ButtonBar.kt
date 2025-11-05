package com.example.pmdm.nicolasComponent

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.NavDestination.Companion.hierarchy

@Composable
fun NavigationBottomBar(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val items = listOf(
        com.example.pmdm.navigation.Destination.Start,
        com.example.pmdm.navigation.Destination.ListContend,
        com.example.pmdm.navigation.Destination.Details,
        com.example.pmdm.navigation.Destination.Profile
    )

    val backStackEntry by navController.currentBackStackEntryAsState()

    NavigationBar(modifier = modifier) {
        items.forEach { dest ->
            val selected = backStackEntry
                ?.destination
                ?.hierarchy
                ?.any { it.route == dest.route } == true

            NavigationBarItem(
                selected = selected,
                onClick = {
                    navController.navigate(dest.route) {
                        popUpTo(navController.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(imageVector = dest.icon, contentDescription = dest.contentDescription)
                },
                label = { Text(dest.label) }
            )
        }
    }
}
