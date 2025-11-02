package com.example.pmdm.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.material3.Text

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Destination.Start.route,
        modifier = modifier
    ) {
        composable(Destination.Start.route)       { StartScreen() }
        composable(Destination.ListContend.route) { ListContendScreen() }
        composable(Destination.Details.route)     { DetailsScreen() }
        composable(Destination.Profile.route)     { ProfileScreen() }
        composable(Destination.Login.route)       { LoginScreen() } // fuera de la barra
    }

}

/* --------- Stubs de pantallas: reemplázalos por tus composables reales --------- */
@Composable fun StartScreen()       { Text("Pantalla Inicio") }
@Composable fun ListContendScreen() { Text("Pantalla Lista") }
@Composable fun DetailsScreen()     { Text("Pantalla Detalles") }
@Composable fun ProfileScreen()     { Text("Pantalla Perfil") }
@Composable fun LoginScreen()       { Text("Pantalla Login") }

/* Preview simple mostrando Start */
@Preview(showBackground = true)
@Composable
private fun AppNavHostPreview() {
    val navController = rememberNavController()
    AppNavHost(navController = navController)
}
