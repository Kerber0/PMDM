package com.example.pmdm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.pmdm.nicolasComponent.NavigationButtomBar
import com.example.pmdm.ui.theme.PMDMTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // opcional: expande el contenido a los bordes de la pantalla
        setContent {
            PMDMTheme {
                // Muestra tu Scaffold con Toolbar + barra inferior y arranca en Start
                NavigationButtomBar()
            }
        }
    }
}
