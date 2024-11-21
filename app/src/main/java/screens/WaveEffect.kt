package screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@SuppressLint("DefaultLocale")
@Composable
fun WaveEffectDemo() {
    var percent by remember { mutableFloatStateOf(0f) }
    var showMessage by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF101221))
    ) {
        val timeText = (2000 - (percent * 20).toInt()).let {
            val hours = it / 100
            val minutes = it % 100
            String.format("%02d:%02d", hours, minutes)
        }


        WaveView(
            modifier = Modifier
                .fillMaxWidth().align(Alignment.BottomCenter),
            percent = percent,
            onTurtleClick = {
                showMessage = !showMessage
            }
        )

        Column(
            modifier = Modifier
                .align(Alignment.Center), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = timeText,
                style = TextStyle(
                    color = Color.White,
                    fontSize = 48.sp,
                    fontWeight = FontWeight.Thin
                ),
            )

            Spacer(modifier = Modifier.height(24.dp))
            Slider(
                value = percent,
                onValueChange = { percent = it },
                valueRange = 0f..100f,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
            )
        }

        if (showMessage) {
            Text(
                text = "🐢 You've found the turtle! 🐢",
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}
