package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class TaskDao {
    private var _tasks: List<Task> = listOf(Task(name = "Buy milk", complete = true))

    fun insert(task: Task) {
        val newTasks = mutableListOf<Task>()
        newTasks.add(task)
        newTasks.addAll(_tasks)
        _tasks = newTasks
    }

    fun getAll() = _tasks
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val taskDao = TaskDao()
        setContent {
            var tasks = taskDao.getAll()
            Column {
                TaskEditor(Task(name = "", complete = false)) {
                    taskDao.insert(it)
                }
                TaskList(tasks)
            }
        }
    }
}


