package com.task.assignment.Repository;

import com.task.assignment.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("roleRepository")
public interface RoleRepository  extends JpaRepository<Role, Long> {
}
