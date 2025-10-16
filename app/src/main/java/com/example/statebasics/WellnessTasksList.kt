package com.example.statebasics

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun WellnessTasksList(
    tasks: List<WellnessTask>,
    onCheckChanged: (task: WellnessTask, isChecked: Boolean) -> Unit,
    onCloseTask: (task: WellnessTask) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(tasks, { task -> task.id }) { task ->
            WellnessTaskItem(
                task = task,
                onCheckChanged = onCheckChanged,
                onClose = onCloseTask
            )
        }
    }
}