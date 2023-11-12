package com.task.assignment.Facade.TaskFacadeImpl;

import com.task.assignment.Exception.InvalidInputException;
import com.task.assignment.DTO.TaskRequestCreateDTO;
import com.task.assignment.DTO.TaskRequestUpdateDTO;
import com.task.assignment.Entity.Task;
import com.task.assignment.Facade.TaskFacade;
import com.task.assignment.Services.Converter.Converter;
import com.task.assignment.Services.TaskServices.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("taskFacade")
public class TaskFacadeImpl implements TaskFacade {
    Logger logger = LoggerFactory.getLogger(TaskFacadeImpl.class);
    private TaskService taskService ;
    private Converter<TaskRequestUpdateDTO, Task> converter ;
    private Converter<Task , Task> taskConverter ;
    private Converter<TaskRequestCreateDTO , Task> createConverter ;

    @Override
    public List<TaskRequestUpdateDTO> getAllTasks() {
        List<Task> taskList =  taskService.getAll() ;
        List<TaskRequestUpdateDTO> taskDTOS = new ArrayList<>() ;
        for(Task task : taskList) {
            taskDTOS.add(converter.convertToDTO(task)) ;
        }
        return taskDTOS;
    }

    @Override
    public void createNewTask(TaskRequestCreateDTO taskDTO) {
        Task task = createConverter.convertToEntity(taskDTO) ;
        taskService.createNewTask(task);
    }

    @Override
    public TaskRequestUpdateDTO getSingleTask(String id) {
        if(id != null) {
            Task task = taskService.getTask(Long.parseLong(id)) ;
            if(task != null){
              return converter.convertToDTO(task) ;
            }
            throw new NullPointerException("can not find task");
        }
        else {
            throw new InvalidInputException("id can not null");
        }
    }
    @Override
    public void updateTask(String id, TaskRequestUpdateDTO taskDTO) {
        if(id != null) {
            taskDTO.setId(id);
            Task task = converter.convertToEntity(taskDTO) ;
            taskService.updateTask(Long.parseLong(id), taskConverter.convertToEntity(task));
        }
        else {
            throw new InvalidInputException("id can not null");
        }
    }
    @Override
    public void deleteTaskById(String id) {
        if(id != null) {
            taskService.deleteTaskId(Long.parseLong(id));
        }
        else {
            throw new InvalidInputException("id can not null");
        }
    }


    @Autowired
    @Qualifier("taskServiceImpl")
    private void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }
    @Autowired
    @Qualifier("taskConverter")
    private void setConverter(Converter<TaskRequestUpdateDTO, Task> converter) {
        this.converter = converter;
    }
    @Autowired
    @Qualifier("taskUpdateConverter")
    private void setTaskConverter(Converter<Task, Task> taskConverter) {
        this.taskConverter = taskConverter;
    }
    @Autowired
    @Qualifier("taskCreateFromDTOConverter")
    public void setCreateConverter(Converter<TaskRequestCreateDTO, Task> createConverter) {
        this.createConverter = createConverter;
    }
}
