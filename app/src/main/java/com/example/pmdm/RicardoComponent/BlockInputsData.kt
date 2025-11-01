package com.example.pmdm.ricardoComponent

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
    val textLabel: String,
    val textValue: String
)
@Composable
fun BlockInputsData(
    modifier: Modifier = Modifier,
    title: String = "REGISTRATE",
    input: List<InputFieldConfig>,

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
                        textValue = inputConfig.textLabel,
                        textInfo = inputConfig.textValue
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
            textLabel = "USER:",
            textValue = "INTRODUCE USUARIO"
        ),
        InputFieldConfig(
            textLabel = "EMAIL:",
            textValue = "INTRODUCE EMAIL"
        ),
        InputFieldConfig(
            textLabel = "PASSWORD:",
            textValue = "INTRODUCE PASSWORD"
        ),
        InputFieldConfig(
            textLabel = "REPITE:",
            textValue = "CONFIRMA CONTRASEÑA"
        )
    )
    BlockInputsData(input = inputs)
}

