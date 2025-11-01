import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pmdm.RicardoComponent.TextComponent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldComponent(
    info: String,
    color: Color,
    placeholderText: (@Composable () -> Unit )? = null
){
    var text by remember { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { text = it },
        placeholder = {
            TextComponent(
                text = info,
                textColor = color,
                textSize = 20.sp
            )
        },
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .fillMaxWidth().padding(4.dp)
    )
}

@Preview
@Composable
fun PreviewTextField(){
    TextFieldComponent("prueba", Color.Black)
}