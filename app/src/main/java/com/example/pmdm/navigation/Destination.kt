package com.example.pmdm.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Destination(
    val route: String,
    val icon: ImageVector,
    val label: String,
    val contentDescription: String
) {
    // Pantallas visibles en la BottomBar
    data object Start : Destination(
        route = "start",
        icon = Icons.Default.Home,
        label = "Inicio",
        contentDescription = "Pantalla de inicio"
    )

    data object ListContend : Destination(
        route = "listContend",
        icon = Icons.AutoMirrored.Filled.List,
        label = "Lista",
        contentDescription = "Pantalla de lista"
    )

    data object Details : Destination(
        route = "details",
        icon = Icons.Default.Info,
        label = "Detalles",
        contentDescription = "Pantalla de detalles"
    )

    data object Profile : Destination(
        route = "profile",
        icon = Icons.Default.Person,
        label = "Perfil",
        contentDescription = "Pantalla de perfil"
    )

    // Pantalla fuera de la BottomBar
    data object Login : Destination(
        route = "login",
        icon = Icons.Default.AccountBox,
        label = "Login",
        contentDescription = "Pantalla de login"
    )

    companion object {
        // Sólo las pantallas que deben aparecer en la BottomBar
        val entries: List<Destination> = listOf(Start, ListContend, Details, Profile)
    }
}
