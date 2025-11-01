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
    object Start : Destination("start", Icons.Default.Home, "Inicio", "Pantalla de inicio")
    object ListContend : Destination("listContend", Icons.AutoMirrored.Filled.List, "Lista", "Pantalla de lista")
    object Details : Destination("details", Icons.Default.Info, "Detalles", "Pantalla de detalles")
    object Profile : Destination("profile", Icons.Default.Person, "Perfil", "Pantalla de perfil")
    // Mantén Login fuera de entries para que no salga como botón
    object Login : Destination("login", Icons.Default.AccountBox, "Login", "Pantalla de login")

    companion object {
        val entries = listOf(Start, ListContend, Details, Profile)
    }
}
