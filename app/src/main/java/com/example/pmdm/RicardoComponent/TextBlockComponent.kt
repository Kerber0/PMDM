package com.example.pmdm.RicardoComponent

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class TextBlockConfig(
    var titleBlock: String,
    var title: String = "",
    var descrip: String,
    var titleSize: TextUnit,
    var descripSize: TextUnit,
)

@Composable
fun TextBlockComponent(info: List<TextBlockConfig>) {
    Column() {
        info.forEach { inf ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(5.dp, Color.Black, RoundedCornerShape(40.dp))
                    .background(Color.Transparent)
            ) {
                Row(
                    modifier = Modifier
                        .padding(15.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(5.dp)
                            .weight(0.4f)
                    ) {
                        TextComponent(
                            text = inf.titleBlock+"\n" + inf.title,
                            textSize = inf.titleSize,
                            textColor = Color.White
                        )
                    }
                    Box(
                        modifier = Modifier
                            .weight(0.6f)
                    ) {
                        TextComponent(text = inf.descrip, textSize = inf.descripSize)
                    }
                }
            }
            Spacer(modifier = Modifier.height(5.dp)
            )
        }
    }
}

@Preview
@Composable
fun PreviewTextBlock() {
    var infos = listOf(
        TextBlockConfig(
            titleBlock = "SINOPSIS",
            title = "Naruto",
            descrip = "Naruto sigue a un joven ninja marginado, Naruto Uzumaki, que sueña con convertirse en Hokage, el líder de su aldea, para ganar reconocimiento. Lleva dentro al demonio Zorro de Nueve Colas, lo que lo hace temido por muchos. La historia muestra su crecimiento, sus amistades y sus batallas por proteger lo que ama.",
            titleSize = 20.sp,
            descripSize = 15.sp
        ),
        TextBlockConfig(
            titleBlock = "INFORMACION",
            descrip = "Tipo:\n" +
                    "Serie\n" +
                    "\nGeneros:\n" +
                    "Super Poderes, Shounen, Artes Marciales, Comedia, Accion\n" +
                    "\nStudios:\n" +
                    "Pierrot\n" +
                    "\nTemporada:\n" +
                    "Otoño 2002\n" +
                    "\nDemografia:\n" +
                    "Shounen\n" +
                    "\nIdiomas:\n" +
                    "Japonés\n" +
                    "\nEpisodios:\n" +
                    "220\n" +
                    "\nDuracion:\n" +
                    "23 min. por episodio\n" +
                    "\nEmitido:\n" +
                    "Jueves, 03 de Octubre de 2002",
            titleSize = 18.sp,
            descripSize = 15.sp
        )
    )

    TextBlockComponent(info = infos)
}