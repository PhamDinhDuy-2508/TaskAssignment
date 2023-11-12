package com.task.assignment.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component("user")
@Entity
@Table(name = "user")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String name;
    @Column
    private String password;
    @Column(insertable = false, updatable = false)
    private Long role_id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "role_id", referencedColumnName = "role_id", columnDefinition = "json")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Role role;

}
