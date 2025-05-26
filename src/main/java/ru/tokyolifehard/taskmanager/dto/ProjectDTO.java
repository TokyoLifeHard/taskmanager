package ru.tokyolifehard.taskmanager.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import ru.tokyolifehard.taskmanager.entity.Status;

import java.time.Instant;
@Getter
@Setter
public class ProjectDTO {
    private String name;
    private String description;
    @Setter(AccessLevel.NONE)
    private Instant startDate;
    private Instant endDate;
    private Status status;

    public void setStartDate(Instant startDate) {
        this.startDate = Instant.now();
    }
}
