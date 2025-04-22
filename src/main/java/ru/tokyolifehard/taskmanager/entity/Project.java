package ru.tokyolifehard.taskmanager.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
    private Status status;

    @OneToMany(mappedBy = "project")
    private Set<Task> tasks;
}
