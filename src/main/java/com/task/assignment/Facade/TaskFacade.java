package com.task.assignment.Facade;

import com.task.assignment.DTO.TaskRequestCreateDTO;
import com.task.assignment.DTO.TaskRequestUpdateDTO;

import java.util.List;

public interface TaskFacade {
    List<TaskRequestUpdateDTO> getAllTasks() ;
    void createNewTask(TaskRequestCreateDTO dto) ;
    TaskRequestUpdateDTO getSingleTask(String id) ;
    void updateTask(String id, TaskRequestUpdateDTO dto) ;
    void deleteTaskById(String id) ;

}
