package com.example.pmdm.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80,
    background = Fondo_Oscuro,
    primaryFixed = Icon,

)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40,
    background = Fondo_Claro,
    primaryFixed = Icon



    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)



// GRADIENTE MÁS VISIBLE (vertical + más contraste)
val MaterialTheme.backgroundGradient: Brush
    @Composable
    get() = if (isSystemInDarkTheme()) {
        // OSCURO: gradiente sutil pero visible
        Brush.verticalGradient(
            colors = listOf(
                Color(0xFF000000),  // Negro puro
                Color(0xFF0F1419)   // Gris azulado oscuro
            )
        )
    } else {
        // CLARO: TUS COLORES + MEJOR CONTRASTE
        Brush.verticalGradient(
            0.0f to Color(0xFFFFF4F8),     // Rosa pálido (inicio)
            0.5f to Color(0xFFB3E5FC),     // Azul más intenso (medio)
            1.0f to Color(0xFFFDFDF5)      // Crema (final)
        )
    }


// GRADIENTE NEÓN IGUAL AL TEXTO DEL LOGO
val MaterialTheme.neonTextGradient: Brush
    @Composable
    get() = Brush.horizontalGradient(
        colors = listOf(
            Color(0xFFFF00E5),  // Rosa neón (inicio)
            Color(0xFF00FFFF),  // Cian neón (medio)
            Color(0xFF0088FF)   // Azul neón (final)
        )
    )


@Composable
fun PMDMTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )




}