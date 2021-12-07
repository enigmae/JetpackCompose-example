package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val taskDao = TaskDao()
        val taskDao = TaskDatabase.getInstance(this).taskDao
        val vmf = MyViewModelFactory(taskDao)
        setContent {
            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = "/tasks") {
                composable("/tasks") {
                    TasksScreen(vmf, onAddTask = {
                        navController.navigate("/tasks/new")
                    },
                        onClickTask = {
                            navController.navigate("/tasks/${it.id}")
                        }
                    )
                }
                composable("/tasks/new") {
                    AddTaskScreen(vmf, onTaskSaved = {
                        navController.navigate("/tasks")
                    })
                }
                composable(
                    "/tasks/{taskId}",
                    arguments = listOf(navArgument("taskId") {
                        type = NavType.LongType
                    })
                ) {
                    it.arguments?.let {
                        val taskId = it.get("taskId") as Long
                        EditTaskScreen(vmf, taskId = taskId, onTaskSaved = {
                            navController.navigate("/tasks")
                        })
                    }
                }
            }
        }
    }
}


