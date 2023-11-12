package com.task.assignment.Services.TaskServices;

import com.task.assignment.Entity.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAll();

    Task getTask(Long id);

    void createNewTask(Task task);

    void updateTask(Long id, Task task);

    void deleteTaskId(Long id);


}
