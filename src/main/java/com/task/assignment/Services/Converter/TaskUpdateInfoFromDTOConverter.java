package com.task.assignment.Services.Converter;

import com.task.assignment.DTO.TaskRequestUpdateDTO;
import com.task.assignment.Entity.Task;
import org.springframework.stereotype.Service;

@Service("taskConverter")
public class TaskUpdateInfoFromDTOConverter implements Converter<TaskRequestUpdateDTO, Task> {
    @Override
    public Task convertToEntity(final TaskRequestUpdateDTO source) {
        Task task = new Task() ;
        if(source.getId() != null) {
            task.setId(Long.parseLong( source.getId()));
        }
        task.setComplete(source.getComplete());
        task.setTitle(source.getTitle());
        task.setDescription(source.getDescription());
        return task ;
    }

    @Override
    public TaskRequestUpdateDTO convertToDTO(Task source) {
        TaskRequestUpdateDTO target = new TaskRequestUpdateDTO() ;
        if(source.getId() != null) {
            target.setId( source.getId().toString());
        }
        target.setComplete(source.getComplete());
        target.setTitle(source.getTitle());
        target.setDescription(source.getDescription());
        return target ;
    }

}
