package com.example.myapplication

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TaskList(tasks: List<Task>, onClickTask: (Task) -> Unit) {
    LazyColumn {
        items(tasks.size) {
            val task = tasks[it]
            TaskItem(task, onClickTask = onClickTask)
        }
    }
}

@Composable
fun TaskItem(task: Task, onClickTask: (Task) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable {
                onClickTask(task)
            },
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(0.9f),
            text = task.name,
        )
        Text(if (task.complete) "  ✓" else "")
    }
}