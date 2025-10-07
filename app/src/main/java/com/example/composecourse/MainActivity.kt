package com.example.composecourse

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composecourse.ui.theme.Blue
import com.example.composecourse.ui.theme.JetpackComposeCourseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeCourseTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp(
    modifier: Modifier = Modifier
) {
    var shouldShowOnboarding by rememberSaveable { mutableStateOf(true) }

    Surface(modifier = modifier) {
        when (shouldShowOnboarding) {
            true -> OnboardingScreen {
                shouldShowOnboarding = false
            }

            false -> {
                val names = arrayListOf<String>().apply {
                    repeat(10) {
                        addAll(NAMES)
                    }
                }
                Greetings(names = names)
            }
        }
    }
}

@Composable
fun OnboardingScreen(
    modifier: Modifier = Modifier,
    onContinueClick: () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
    ) {
        Text("Welcome to the Basics Codelab!")
        Button(
            modifier = Modifier.padding(vertical = 24.dp),
            onClick = { onContinueClick() }
        ) {
            Text("Continue")
        }
    }
}

@Composable
fun Greetings(
    modifier: Modifier = Modifier,
    names: List<String>
) {
    LazyColumn(modifier = modifier.padding(vertical = 4.dp)) {
        items(items = names) { name ->
            Greeting(name)
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

    var expanded by rememberSaveable { mutableStateOf(false) }

    val extraPadding by animateDpAsState(
        targetValue = when (expanded) {
            true -> 48.dp
            false -> 0.dp
        },
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        )
    )

    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = modifier.padding(4.dp, 4.dp)
    ) {
        Row(modifier = modifier.padding(24.dp)) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = extraPadding.coerceAtLeast(0.dp))
            ) {
                Text(text = "Hello")
                Text(
                    text = "$name!",
                    style = MaterialTheme.typography.headlineMedium.copy(
                        fontWeight = FontWeight.ExtraBold
                    )
                )
            }
            ElevatedButton(
                colors = ButtonDefaults.elevatedButtonColors(
                    containerColor = Blue,
                    contentColor = Color.White
                ),
                onClick = {
                    expanded = !expanded
                }) {
                Text(
                    text = when (expanded) {
                        true -> "Show Less"
                        false -> "Show More"
                    }
                )
            }
        }
    }
}

// Previews

@Preview(
    name = "My App Preview",
    showBackground = true,
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun MyAppPreview() {
    JetpackComposeCourseTheme {
        MyApp()
    }
}

val NAMES = listOf("Taymoor", "Android", "Compose")