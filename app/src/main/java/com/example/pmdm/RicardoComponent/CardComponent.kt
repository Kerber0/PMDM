package com.example.pmdm.RicardoComponent

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

class CardConfig(var ImageId: Int, var ImageDesc: String = "", var Title: String)
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
                        painter = painterResource(id = cardConfig.ImageId),
                        contentDescription = cardConfig.ImageDesc
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Column {
                            TextComponent(
                                text = cardConfig.Title,
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
            ImageId = R.drawable.dragonball,
            ImageDesc = "Dragon Ball Z",
            Title = "DRAGON BALL Z"
        )
        ,CardConfig(
            ImageId = R.drawable.naruto,
            ImageDesc = "Naruto",
            Title = "NARUTO"
        ),
        CardConfig(
            ImageId = R.drawable.bleach,
            ImageDesc = "Bleach",
            Title = "BLEACH"
        ), CardConfig(
            ImageId = R.drawable.onepiece,
            ImageDesc = "onePiece",
            Title = "ONEPIECE"
        )
    )

    CardComponent(input = inputs)

}