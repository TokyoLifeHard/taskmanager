package ru.tokyolifehard.taskmanager.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String title;
    private String description;
    private Status status;
    private Priority priority;
    private Instant dueDate;
    private Instant createdAt;
    private Instant updatedAt;

    @ManyToOne
    @JoinColumn(name="user_id")
    private AppUser user;

    @ManyToOne
    @JoinColumn(name="project_id")
    private Project project;

}
