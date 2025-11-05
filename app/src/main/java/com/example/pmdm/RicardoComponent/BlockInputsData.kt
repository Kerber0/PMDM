package com.example.pmdm.RicardoComponent

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class InputFieldConfig(
    val TextLabel: String,
    val TextValue: String
)
@Composable
fun BlockInputsData(
    title: String = "REGISTRATE",
    input: List<InputFieldConfig>,
    modifier: Modifier = Modifier,
    borderColor: Color = Color.Black
){
    Box(modifier = Modifier
        .border(
            width = 5.dp,
            color = borderColor,
            shape = RoundedCornerShape(10.dp)
        )
        .padding(10.dp)
        .background(Color(0xFF0A0D1F))
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            TextComponent(
                text = title,
                textSize = 20.sp,
                textColor = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp)
            )
            Column(
                modifier = Modifier.fillMaxWidth().padding(top = 10.dp),
                verticalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                input.forEach { inputConfig ->
                    InputDataComponent(
                        textValue = inputConfig.TextLabel,
                        textInfo = inputConfig.TextValue
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewInputs(){
    val inputs = listOf(
        InputFieldConfig(
            TextLabel = "USER:",
            TextValue = "INTRODUCE USUARIO"
        ),
        InputFieldConfig(
            TextLabel = "EMAIL:",
            TextValue = "INTRODUCE EMAIL"
        ),
        InputFieldConfig(
            TextLabel = "PASSWORD:",
            TextValue = "INTRODUCE PASSWORD"
        ),
        InputFieldConfig(
            TextLabel = "REPITE:",
            TextValue = "CONFIRMA CONTRASEÑA"
        )
    )
    BlockInputsData(input = inputs)
}

