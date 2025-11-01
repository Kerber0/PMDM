package com.example.pmdm.PagesC

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pmdm.R
import com.example.pmdm.ricardoComponent.BlockInputsData
import com.example.pmdm.ricardoComponent.ButtomComponent
import com.example.pmdm.ricardoComponent.InputFieldConfig

@Composable
fun LoginPage(){
    Box(modifier = Modifier.fillMaxSize()) {

        Image(
            painter = painterResource(id = R.drawable.fondo),
            contentDescription = "Fondo Imagen Genereico",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
        ){
            Box(modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.TopEnd
            ){
                Image(
                    painter = painterResource(id = R.drawable.tema_oscuro),
                    contentDescription = "Logo Imagen Generico",
                    modifier = Modifier
                        .size(90.dp)
                        .clip(RoundedCornerShape(size = 40.dp)
                        )
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentAlignment = Alignment.Center
            ){
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

                BlockInputsData(
                    title = "REGISTRO",
                    input = inputs,
                    borderColor = Color.Red
                )
            }

            Box(modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.TopEnd
            ){
                Row(
                    modifier = Modifier.padding(10.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    ButtomComponent(text = "CREAR CUENTA") {
                        Log.e("Prueba","Clieck en crear cuenta")
                    }

                    ButtomComponent(text = "INICIAR SECION") {
                        Log.e("Prueba2","Click en inicar secion")
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewLoginPage(){
    LoginPage()
}