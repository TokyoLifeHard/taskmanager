package ru.tokyolifehard.taskmanager.dto;

import lombok.*;
import ru.tokyolifehard.taskmanager.entity.Priority;


import java.time.Instant;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TaskDTO {
    private String title;
    private String description;
    private String projectName;
    private Priority priority;
    private Instant leadTime;
    @Setter(AccessLevel.NONE) private Instant createdAt;

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = Instant.now();
    }
}
