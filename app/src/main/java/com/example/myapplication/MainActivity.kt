package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.*
import androidx.compose.runtime.Composable

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
    var name = "Buy bread"
    Column {
        TextField(
            value = name,
            onValueChange = {
                            name = it
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
