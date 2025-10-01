package com.example.composecourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composecourse.ui.theme.JetpackComposeCourseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeCourseTheme {
                MyApp(names = NAMES)
            }
        }
    }
}

@Composable
fun MyApp(
    modifier: Modifier = Modifier,
    names: List<String>
) {
    Column(modifier = modifier.padding(4.dp)) {
        names.forEach { name ->
            Greeting(name)
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = modifier.padding(4.dp, 4.dp)
    ) {
        Row(modifier = modifier.padding(24.dp)) {
            Column(
                modifier = Modifier
                    .weight(1f)
            ) {
                Text(text = "Hello")
                Text(text = "$name!")
            }
            ElevatedButton(
                onClick = {

                }) {
                Text("Show More")
            }
        }
    }
}

// Previews

@Preview(
    name = "Text Preview",
    showBackground = true,
    showSystemUi = true
)
@Composable
fun MyAppPreview() {
    JetpackComposeCourseTheme {
        MyApp(names = NAMES)
    }
}

val NAMES = listOf("Taymoor", "Android", "Compose")