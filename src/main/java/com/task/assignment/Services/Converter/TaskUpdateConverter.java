package com.task.assignment.Services.Converter;

import com.task.assignment.Exception.TaskException;
import com.task.assignment.Entity.Task;
import com.task.assignment.Services.TaskServices.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("taskUpdateConverter")
public class TaskUpdateConverter implements Converter<Task,Task> {
    private TaskService taskService ;
    @Override
    public Task convertToEntity(Task source) {
        Task target =  taskService.getTask(source.getId()) ;
        if(target == null) {
            throw new TaskException("Task with id:"+ source.getId() +" is not existed");
        }
        if(source.getComplete() != null) {
            target.setComplete(source.getComplete());
        }
        if(source.getDescription() != null) {
            target.setDescription(source.getDescription());
        }
        if(source.getTitle() != null) {
            target.setTitle(source.getTitle());
        }
        return target ;
    }

    @Override
    public Task convertToDTO(Task task) {
        return null;
    }

    @Autowired
    @Qualifier("taskServiceImpl")
    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }
}
