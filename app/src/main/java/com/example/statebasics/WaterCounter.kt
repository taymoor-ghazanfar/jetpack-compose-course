package com.example.statebasics

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun WaterCounter(modifier: Modifier = Modifier) {

    var count by remember { mutableIntStateOf(0) }
    var isTaskClosed by remember { mutableStateOf(false) }
    val showTask by remember { derivedStateOf { (count > 0) && !isTaskClosed } }
    val isButtonEnabled by remember { derivedStateOf { (count < 10) } }

    Column(
        modifier = modifier.padding(16.dp)
    ) {
        if (showTask) {
            WellnessTaskItem(
                taskName = "Have you taken your 15 minute walk today?",
                onClose = {
                    isTaskClosed = true
                }
            )
        }
        if (count > 0) {
            Text(text = "You've had $count glasses")
            Spacer(
                modifier = Modifier.height(8.dp)
            )
        }
        Row {
            Button(
                enabled = isButtonEnabled,
                onClick = {
                    count++
                }
            ) {
                Text("Add one")
            }
            Spacer(
                modifier = Modifier.width(8.dp)
            )
            Button(
                onClick = {
                    count = 0
                }
            ) {
                Text("Clear water count")
            }
        }
    }
}