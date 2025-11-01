package com.example.pmdm.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.pmdm.pagesC.DetailsPage
import com.example.pmdm.pagesC.ListContendPage
import com.example.pmdm.pagesC.ProfilePage
import com.example.pmdm.pagesC.StartPage
import com.example.pmdm.pagesC.LoginPage


@Composable
fun AppNavHost(
    navController: NavHostController,
    startDestination: Destination,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = startDestination.route,
        modifier = modifier
    ) {
        composable(Destination.Start.route)   { StartPage() }
        composable(Destination.ListContend.route) { ListContendPage() }
        composable(Destination.Details.route) { DetailsPage() }
        composable(Destination.Profile.route) { ProfilePage() }
        composable (Destination.Profile.route) {LoginPage()}
    }
}
