package com.task.assignment.Repository;

import com.task.assignment.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("userRepository")
public interface UserRepository<S extends  User> extends JpaRepository<S , Long> {
    Optional<S> findByName(String username);
}
