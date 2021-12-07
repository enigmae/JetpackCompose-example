package com.example.myapplication

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TaskList(tasks: List<Task>) {
    LazyColumn {
        items(tasks.size) {
            val task = tasks[it]
            TaskItem(task)
        }
    }
}

@Composable
private fun TaskItem(task: Task) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
    ) {
        Text(task.name)
        Text(if (task.complete) "  ✓" else "")
    }
}