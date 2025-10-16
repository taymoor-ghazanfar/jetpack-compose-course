package com.example.statebasics

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,
    viewModel: WellnessViewModel = viewModel()
) {
    val tasks by viewModel.tasksState.collectAsState()

    Column(
        modifier = modifier
    ) {
        StatefulCounter(modifier)
        WellnessTasksList(
            tasks = tasks,
            onCheckChanged = { task, isChecked ->
                viewModel.toggleTaskCheck(task, isChecked)
            },
            onCloseTask = { task ->
                viewModel.removeTask(task)
            }
        )
    }
}