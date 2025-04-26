package ru.tokyolifehard.taskmanager.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter

public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String username;
    private String email;
    //Todo or password hash?
    private String password;
    private LocalDateTime createdTime;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private Set<Task> tasks;
}
