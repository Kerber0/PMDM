package com.example.pmdm.ricardoComponent

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ButtomComponent(text: String, action: () -> Unit){
    Box(modifier = Modifier
        .width(width = 160.dp)
        .height(height = 50.dp)
    ){
        Button(
            onClick = action,
            modifier = Modifier
                .fillMaxWidth(),
            colors = ButtonColors(
                containerColor = Color.DarkGray,
                contentColor = Color.White,
                disabledContainerColor = Color.LightGray,
                disabledContentColor = Color.Red
            )
        ) {
            TextComponent(text = text, textSize = 10.sp)
        }
    }
}

@Preview
@Composable
fun previewButtom(){
    ButtomComponent("CREAR CUENTA") {
        Log.e("Prueba","Click botom")
    }
}