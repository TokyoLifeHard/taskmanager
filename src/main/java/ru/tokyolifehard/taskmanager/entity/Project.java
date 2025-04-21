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
public class Project {

    @Id
    @GeneratedValue()
    private Long id;
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
    private Status status;
}
