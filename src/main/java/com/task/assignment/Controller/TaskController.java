package com.task.assignment.Controller;

import com.task.assignment.DTO.TaskRequestCreateDTO;
import com.task.assignment.DTO.TaskRequestUpdateDTO;
import com.task.assignment.Facade.TaskFacade;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@Validated
public class TaskController {
    Logger logger = LoggerFactory.getLogger(TaskController.class);
    private TaskFacade taskFacade;

    @GetMapping("/tasks/getAll")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(taskFacade.getAllTasks());
    }

    @PostMapping("/tasks/create")
    public ResponseEntity<?> create(@RequestBody @Valid TaskRequestCreateDTO taskDTO) {
        taskFacade.createNewTask(taskDTO);
        return ResponseEntity.ok("Created new Task");
    }

    @GetMapping("/tasks/get/{id}")
    public ResponseEntity<?> get(@PathVariable("id")
                                 @Pattern(regexp = "\\d+", message = "Invalid value. Only numeric characters allowed.") String id) {
        return ResponseEntity.ok(taskFacade.getSingleTask(id));
    }

    @PutMapping("/tasks/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")
                                    @Pattern(regexp = "\\d+", message = "Invalid value. Only numeric characters allowed.") String id,
                                    @RequestBody @Valid TaskRequestUpdateDTO taskDTO) {
        taskFacade.updateTask(id, taskDTO);
        return ResponseEntity.ok("update task with id: " + id);
    }

    @DeleteMapping("/tasks/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")
                                    @Pattern(regexp = "\\d+", message = "Invalid value. Only numeric characters allowed.") String id) {
        taskFacade.deleteTaskById(id);
        return ResponseEntity.ok("delete task with id: " + id);
    }

    @Autowired
    @Qualifier("taskFacade")
    public void setTaskFacade(TaskFacade taskFacade) {
        this.taskFacade = taskFacade;
    }
}
