package com.example.statebasics

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun WellnessTaskItem(
    task: WellnessTask,
    onCheckChanged: (task: WellnessTask, isChecked: Boolean) -> Unit,
    onClose: (task: WellnessTask) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Text(
            text = task.label,
            modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp),
        )
        Checkbox(
            checked = task.isChecked,
            onCheckedChange = { onCheckChanged(task, it) }
        )
        IconButton(
            onClick = { onClose(task) }
        ) {
            Icon(Icons.Filled.Close, contentDescription = "Close")
        }
    }
}