package com.task.assignment.Services.Converter;

import com.task.assignment.DTO.TaskRequestCreateDTO;
import com.task.assignment.Entity.Task;
import org.springframework.stereotype.Service;

@Service("taskCreateFromDTOConverter")
public class TaskCreateFromDTOConverter implements Converter<TaskRequestCreateDTO, Task> {

    @Override
    public Task convertToEntity(TaskRequestCreateDTO source) {
        Task task = new Task() ;
        task.setComplete(source.getComplete());
        task.setTitle(source.getTitle());
        task.setDescription(source.getDescription());
        return task ;
    }

    @Override
    public TaskRequestCreateDTO convertToDTO(Task task) {
        return null;
    }
}
