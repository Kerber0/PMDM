package com.example.pmdm.RicardoComponent

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.pmdm.R

data class CardConfig(
    val id: Int,
    val imageId: Int,
    val imageDesc: String = "",
    val title: String,
    val synopsis: String,
    val info: String
)
@Composable
fun CardComponent(input: List<CardConfig>, navController: NavController){

    Column {
        input.forEach { cardConfig ->
            Card(modifier = Modifier
                .width(220.dp)
                .height(100.dp)
                .padding(4.dp),
                onClick = { navController.navigate("details/${cardConfig.id}") }
            ){
                Row{
                    Image(
                        painter = painterResource(id = cardConfig.imageId),
                        contentDescription = cardConfig.imageDesc
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Column {
                            TextComponent(
                                text = cardConfig.title,
                                textColor = Color.Black,
                                textSize = 15.sp
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewCard(){
    val inputs = listOf(
        CardConfig(
            id = 0,
            imageId = R.drawable.dragonball,
            imageDesc = "Dragon Ball Z",
            title = "DRAGON BALL Z",
            synopsis = "",
            info = ""
        ),
        CardConfig(
            id = 0,
            imageId = R.drawable.evangelion,
            imageDesc = "Dragon Ball Z",
            title = "DRAGON BALL Z",
            synopsis = "",
            info = ""
        )

    )

    CardComponent(input = inputs, navController = rememberNavController())

}