package com.example.statebasics

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class WellnessViewModel : ViewModel() {

    private val _tasksState = MutableStateFlow(getWellnessTasks())
    val tasksState get() = _tasksState.asStateFlow()

    fun removeTask(task: WellnessTask) {
        val tasks = _tasksState.value.filter { it.id != task.id }
        _tasksState.value = tasks
    }

    fun toggleTaskCheck(task: WellnessTask, isChecked: Boolean) {
        val tasks = _tasksState.value.map {
            when (it.id == task.id) {
                true -> it.copy(isChecked = isChecked)
                false -> it.copy()
            }
        }
        _tasksState.value = tasks
    }

    private fun getWellnessTasks() =
        List(30) { i -> WellnessTask(i, "Task # $i", false) }
}