package com.task.assignment.Services.TaskServices.TaskServiceImpl;

import com.task.assignment.Exception.TaskException;
import com.task.assignment.Entity.Task;
import com.task.assignment.Repository.TaskRepository;
import com.task.assignment.Services.TaskServices.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

@EnableAsync
@Service("taskServiceImpl")
public class TaskServiceImpl implements TaskService {
    Logger logger = LoggerFactory.getLogger(TaskServiceImpl.class);
    private TaskRepository taskRepository;

    @Override
    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTask(Long id) {
        return findById(id) == null ? null : findById(id);
    }

    @Override
    @Async
    public void createNewTask(Task task) {
        try {
            taskRepository.saveAndFlush(task);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new TaskException("Can't Create This Task");
        }
    }

    @Override
    public void updateTask(Long id, Task task) {
        try {
            if (task != null) {
                task.setId(id);
                taskRepository.saveAndFlush(task);
            }

        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new TaskException("Can't update this Task");
        }
    }

    @Override
    public void deleteTaskId(Long id) {
        Task task = findById(id);
        if (task != null) {
            taskRepository.delete(task);
        } else {
            throw new TaskException("Task with id:" + id + " is not exsited");
        }
    }

    @Autowired
    public void setTaskRepository(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    private Task findById(Long id) {
        Optional<Task> task = taskRepository.findById(id);
        return task.orElse(null);
    }
}
