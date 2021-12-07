package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskEditor()
        }
    }
}


@Composable
fun TaskEditor() {
    var name = remember { mutableStateOf("Buy bread") }
    Column {
        TextField(
            value = name.value,
            onValueChange = {
                name.value = it
            },
        )
        Row {
            Checkbox(
                checked = true,
                onCheckedChange = {},
            )
            Text("Complete?")
        }
    }
}
