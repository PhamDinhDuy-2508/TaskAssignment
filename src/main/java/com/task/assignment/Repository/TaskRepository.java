package com.task.assignment.Repository;

import com.task.assignment.Entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("taskRepository")
public interface TaskRepository extends JpaRepository<Task , Long> {

}
