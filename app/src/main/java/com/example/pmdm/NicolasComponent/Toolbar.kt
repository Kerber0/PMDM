package com.example.pmdm.nicolasComponent

import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pmdm.R
import com.example.pmdm.ui.theme.PMDMTheme
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.MaterialTheme
import com.example.pmdm.ui.theme.neonTextGradient


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Toolbar() {
    isSystemInDarkTheme()
    val logoRes =  R.drawable.logo

    CenterAlignedTopAppBar(
        title = {
            Image(
                painter = painterResource(id = logoRes),
                contentDescription = "Logo de la app",
                modifier = Modifier.size(160.dp)
            )
        },
        actions = {
            IconButton(
                onClick = { Log.e("Msg", "Botón de ajustes") },
                modifier = Modifier
                    .size(40.dp)
                    .clip(RoundedCornerShape(size = 16.dp))
                    .background(MaterialTheme.colorScheme.primaryFixed)
            ) {
                Icon(
                    imageVector = Icons.Filled.Person,
                    contentDescription = "Ajustes",
                    tint = MaterialTheme.colorScheme.background
                )
            }
        },
        modifier = Modifier.background(MaterialTheme.neonTextGradient).height(64.dp),
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent
        )

    )
}

@Preview(showBackground = true, name = "Toolbar – Tema Claro")
@Composable
fun ToolbarPreviewLight() {
    PMDMTheme(darkTheme = false) {
        Toolbar()
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "Toolbar – Tema Oscuro"
)
@Composable
fun ToolbarPreviewDark() {
    PMDMTheme(darkTheme = true) {
        Toolbar()
    }
}
