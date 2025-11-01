package com.example.pmdm.RicardoComponent

import TextFieldComponent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun InputDataComponent(
    textValue: String,
    textInfo: String,
    placeholder: (@Composable () -> Unit)? = null
){

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            TextComponent(
                text = textValue,
                textSize = 15.sp,
                textColor = Color.White,
                modifier = Modifier
                    .padding(3.dp)
            )

            TextFieldComponent(
                info = textInfo,
                color = Color.Black
            )
        }
}

@Preview
@Composable
fun PreviewInputData(){
    InputDataComponent("User:","INTRODUCE USER")
}