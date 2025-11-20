package com.example.task.data

import com.example.task.TaskModel
import kotlinx.coroutines.flow.Flow

interface TaskRepository {
    fun getTasks(): Flow<List<TaskModel>>
    fun getTask(id: Int): Flow<TaskModel?>
    suspend fun updateTask(task: TaskModel)
}
