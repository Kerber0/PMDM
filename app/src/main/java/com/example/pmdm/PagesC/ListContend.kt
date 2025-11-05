package com.example.pmdm.PagesC

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.pmdm.R
import com.example.pmdm.RicardoComponent. *
import com.example.pmdm.nicolasComponent.Toolbar

@Composable
fun ListContend(navController: NavController) {
    val animeList = DataProvider.animeList

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Image(
            painter = painterResource(id = R.drawable.list_content),
            contentDescription = "Fondo",
            modifier = Modifier.fillMaxHeight(),
            contentScale = ContentScale.Crop
        )
        BlockCardsComponents(input = animeList, navController = navController)
    }
}


//@Preview(showBackground = true)
//@Composable
//fun ListContendPreview() {
//    val context = LocalContext.current
//    val dummyList = listOf(
//        CardConfig(
//            id = 1,
//            imageId = R.drawable.ic_launcher_foreground,
//            imageDesc = "Demo",
//            title = "Ejemplo",
//            synopsis = "Vista previa.",
//            info = "Sólo para probar."
//        )
//    )
//    BlockCardsComponents(input = dummyList)
//}