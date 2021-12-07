package com.example.myapplication

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun MainNavigation(vmf: MyViewModelFactory) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "/tasks") {
        composable("/tasks") {
            MyScaffold(title = "Tasks!") {
                TasksScreen(vmf, onAddTask = {
                    navController.navigate("/tasks/new")
                },
                    onClickTask = {
                        navController.navigate("/tasks/${it.id}")
                    }
                )
            }
        }
        composable("/tasks/new") {
            MyScaffold(title = "Add Task") {
                AddTaskScreen(vmf, onTaskSaved = {
                    navController.navigate("/tasks")
                })
            }
        }
        composable(
            "/tasks/{taskId}",
            arguments = listOf(navArgument("taskId") {
                type = NavType.LongType
            })
        ) {
            it.arguments?.let {
                val taskId = it.get("taskId") as Long
                MyScaffold(title = "Add Task") {
                    EditTaskScreen(vmf, taskId = taskId, onTaskSaved = {
                        navController.navigate("/tasks")
                    })
                }
            }
        }
    }
}

@Composable
fun MyScaffold(
    title: String,
    content: @Composable () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(title)
            })
        }
    ) {
        content()
    }
}