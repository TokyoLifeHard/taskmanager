package ru.tokyolifehard.taskmanager.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import ru.tokyolifehard.taskmanager.entity.Priority;


import java.time.Instant;
import java.util.Date;

@Setter
@Getter
public class TaskDTO {
    private String title;
    private String description;
    private String projectName;
    private Priority priority;
    private String leadTime;
    @Setter(AccessLevel.NONE) private Instant createdAt;

    public void setCreatedAt(Date createdAt) {
        this.createdAt = Instant.now();
    }
}
