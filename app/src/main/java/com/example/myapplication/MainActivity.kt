package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskEditor(Task(name = "Buy fish", complete = true))
        }
    }
}

data class Task(var name: String, var complete: Boolean)

@Composable
fun TaskEditor(task: Task) {
    var name by rememberSaveable { mutableStateOf(task.name) }
    var complete by rememberSaveable { mutableStateOf(task.complete) }
    Column {
        TextField(
            value = name,
            modifier = Modifier.fillMaxWidth(),
            onValueChange = {
                name = it
            },
        )
        Row {
            Checkbox(
                checked = complete,
                onCheckedChange = {
                    complete = it
                },
            )
            Text("Complete?")
        }
    }
}
