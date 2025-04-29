package ru.tokyolifehard.taskmanager.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;


import java.time.Instant;
import java.util.Date;

@Setter
@Getter
public class TaskDTO {
    private String title;
    private String description;
    private String projectName;
    private String leadTime;
    @Setter(AccessLevel.NONE) private Date createdAt;

    public void setCreatedAt(Date createdAt) {
        this.createdAt = Date.from(Instant.now());
    }
}
