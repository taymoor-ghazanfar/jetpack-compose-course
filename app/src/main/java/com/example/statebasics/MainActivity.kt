package com.example.statebasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.statebasics.ui.theme.StateBasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StateBasicsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    WellnessScreen(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Preview()
@Composable
fun WellnessScreenPreview() {
    StateBasicsTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            WellnessScreen(Modifier.padding(innerPadding))
        }
    }
}