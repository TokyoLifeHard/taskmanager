package ru.tokyolifehard.taskmanager.entity;

import jakarta.persistence.*;
import lombok.*;

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
    private Long id;
    private String title;
    private String description;
    private Status status;
    private Priority priority;
    private Date dueDate;
    private Date createdAt;
    private Date updatedAt;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    private Long AssigneeId;
    private Long projectId;
}
