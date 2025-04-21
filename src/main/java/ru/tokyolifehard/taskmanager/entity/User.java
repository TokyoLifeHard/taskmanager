package ru.tokyolifehard.taskmanager.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue()
    private Long id;

    private String username;
    private String email;
    //Todo or password hash?
    private String password;
    private LocalDateTime createdTime;

}
