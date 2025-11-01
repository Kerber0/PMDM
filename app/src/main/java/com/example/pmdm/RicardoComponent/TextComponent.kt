package com.example.pmdm.ricardoComponent

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun TextComponent(
    modifier: Modifier = Modifier,
    text: String,
    textSize: TextUnit = 10.sp,
    textColor: Color = Color.White

){
    Box{
        Text(
            text = text,
            fontSize = textSize,
            color = textColor
        )
    }
}


@Preview
@Composable
fun ViewText(){
    TextComponent(text = "USER:", textSize = 10.sp)
}