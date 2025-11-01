package com.example.pmdm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.pmdm.nicolasComponent.NavigationBottomBar
import com.example.pmdm.nicolasComponent.Toolbar
import com.example.pmdm.navigation.AppNavHost
import com.example.pmdm.navigation.Destination
import com.example.pmdm.ui.theme.PMDMTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Opcional: expande el contenido hasta los bordes de la pantalla
        enableEdgeToEdge()
        setContent {
            PMDMTheme {
                // NavController para todo el grafo de navegación
                val navController = rememberNavController()
                // Destino inicial de tu aplicación
                val startDestination = Destination.Start
                // Estado para saber cuál botón está seleccionado en la barra inferior
                var selectedIndex by rememberSaveable {
                    mutableIntStateOf(Destination.entries.indexOf(startDestination))
                }

                Scaffold(
                    topBar = { Toolbar() }, // Barra superior
                    bottomBar = {
                        // Barra de navegación inferior: recibe NavController y estado seleccionado
                        NavigationBottomBar(
                            navController = navController,
                            selectedIndex = selectedIndex,
                            onItemSelected = { newIndex -> selectedIndex = newIndex }
                        )
                    }
                ) { innerPadding ->
                    // Aquí cargamos el contenido según el destino de navegación
                    AppNavHost(
                        navController = navController,
                        startDestination = startDestination,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
