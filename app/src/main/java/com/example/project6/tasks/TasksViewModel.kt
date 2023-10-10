package com.example.project6.tasks

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TasksViewModel(val dao: TaskDao) : ViewModel() {
    var newTaskName = ""
    val tasks = dao.getAll()
    private val _navigateToTask = MutableLiveData<Long?>()
    val navigateToTask: LiveData<Long?>
        get() = _navigateToTask

    fun addTask() {
        viewModelScope.launch {
            val task = Task()
            task.taskName = newTaskName
            task.taskDescription = newTaskName
            dao.insert(task)
            _navigateToTask.value = taskId

        }

    }
    fun onTaskClicked(taskId: Long) {
        _navigateToTask.value = taskId

    }
    fun onTaskNavigated() {
        _navigateToTask.value = null

    }
    fun deleteTask(taskId: Long) {
        viewModelScope.launch {
            for (i in tasks.value!!.indices){
                if (taskId == tasks.value!![i].taskId){
                    dao.delete(tasks.value!![i])
                }
            }
        }
    }
}