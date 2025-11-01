package com.example.pmdm.ricardoComponent

import androidx.compose.foundation.Image
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
import com.example.pmdm.R

class CardConfig(var imageId: Int, var imageDesc: String = "", var title: String)
@Composable
fun CardComponent(input: List<CardConfig>, action: () -> Unit = {} ){

    Column {
        input.forEach { cardConfig ->
            Card(modifier = Modifier
                .width(200.dp)
                .height(80.dp)
                .padding(4.dp),
                onClick = action
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
            imageId = R.drawable.dragonball,
            imageDesc = "Dragon Ball Z",
            title = "DRAGON BALL Z"
        )
        ,CardConfig(
            imageId = R.drawable.naruto,
            imageDesc = "Naruto",
            title = "NARUTO"
        ),
        CardConfig(
            imageId = R.drawable.bleach,
            imageDesc = "Bleach",
            title = "BLEACH"
        ), CardConfig(
            imageId = R.drawable.onepiece,
            imageDesc = "onePiece",
            title = "ONEPIECE"
        )
    )

    CardComponent(input = inputs)

}