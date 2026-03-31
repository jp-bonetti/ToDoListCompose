package br.edu.satc.todolistcompose.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.edu.satc.todolistcompose.data.TaskDao
import br.edu.satc.todolistcompose.data.TaskData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class TaskViewModel(private val taskDao: TaskDao) : ViewModel() {

    val tasks: Flow<List<TaskData>> = taskDao.getAllTasks()

    fun insertTask(task: TaskData) {
        viewModelScope.launch {
            taskDao.insert(task)
        }
    }

    fun updateTask(task: TaskData) {
        viewModelScope.launch {
            taskDao.update(task)
        }
    }

    fun deleteTask(id: Int) {
        viewModelScope.launch {
            taskDao.delete(id)
        }
    }
}
