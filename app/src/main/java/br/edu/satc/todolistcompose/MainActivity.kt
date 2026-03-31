package br.edu.satc.todolistcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import br.edu.satc.todolistcompose.data.AppDatabase
import br.edu.satc.todolistcompose.ui.screens.HomeScreen
import br.edu.satc.todolistcompose.ui.theme.ToDoListComposeTheme
import br.edu.satc.todolistcompose.ui.viewmodel.TaskViewModel
import br.edu.satc.todolistcompose.ui.viewmodel.TaskViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val database = AppDatabase.getDatabase(applicationContext)
        val taskDao = database.taskDao()
        val viewModelFactory = TaskViewModelFactory(taskDao)

        setContent {
            ToDoListComposeTheme {
                val viewModel: TaskViewModel = viewModel(factory = viewModelFactory)
                HomeScreen(viewModel = viewModel)
            }
        }
    }
}
