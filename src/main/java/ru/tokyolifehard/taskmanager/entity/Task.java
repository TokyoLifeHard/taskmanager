package ru.tokyolifehard.taskmanager.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
    @GeneratedValue()
    private Long id;
    private String title;
    private String description;
    private Status status;
    private Priority priority;
    private Date dueDate;
    private Date createdAt;
    private Date updatedAt;
    private Long creatorId;
    private Long AssigneeId;
    private Long projectId;
}
