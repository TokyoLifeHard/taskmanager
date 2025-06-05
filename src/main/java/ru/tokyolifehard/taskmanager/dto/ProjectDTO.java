package ru.tokyolifehard.taskmanager.dto;

import lombok.*;
import ru.tokyolifehard.taskmanager.entity.Status;

import java.time.Instant;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDTO {
    private String name;
    private String description;
    private Instant startDate;
    private Instant endDate;
    private Status status;

    public void setStartDate(Instant startDate) {
        this.startDate = Instant.now();
    }

    private Set<TaskDTO> tasks;
}
