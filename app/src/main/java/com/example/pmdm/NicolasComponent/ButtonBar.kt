package com.example.pmdm.nicolasComponent

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
        bottomBar = {
            NavigationBar {
                Destination.entries.forEachIndexed { index, destination ->
                    NavigationBarItem(
                        selected = selectedIndex == index,
                        onClick = {
                            navController.navigate(destination.route)
                            selectedIndex = index
                        },
                        icon = { Icon(destination.icon, destination.contentDescription) },
                        label = { Text(destination.label) }
                    )
                }
            }
        }
    ) { innerPadding ->
        AppNavHost(
            navController = navController,
            startDestination = startDestination,
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Preview
@Composable
fun NaviPrev(){
    NavigationButtomBar()
}