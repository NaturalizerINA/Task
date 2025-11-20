package com.example.task.data

import com.example.task.TaskModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TaskRepositoryImpl @Inject constructor() : TaskRepository {

    private val _tasks = mutableListOf(
        TaskModel(1, "Task 1: Learn Jetpack Compose", false),
        TaskModel(2, "Task 2: Create a cool app", true),
        TaskModel(3, "Task 3: Share with the world", false),
    )
    private val tasksFlow = MutableStateFlow(_tasks.toList()) // Emit an immutable list

    override fun getTasks(): Flow<List<TaskModel>> {
        return tasksFlow.asStateFlow()
    }

    override fun getTask(id: Int): Flow<TaskModel?> {
        return tasksFlow.asStateFlow().map { tasks ->
            tasks.find { it.id == id }
        }
    }

    override suspend fun updateTask(task: TaskModel) {
        val index = _tasks.indexOfFirst { it.id == task.id }
        if (index != -1) {
            _tasks[index] = task
            tasksFlow.value = _tasks.toList() // toList() creates a new list, which triggers the flow
        }
    }
}
