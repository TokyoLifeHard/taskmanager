package ru.tokyolifehard.taskmanager.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter

@NamedNativeQuery(name = "getProjectById",
        query = "select project.id," +
                "from project" +
                "where id =:projectId",
        resultClass = Project.class
)

@NamedNativeQuery(name = "createProjectById",
        query = "insert into project(name,description,startDate,endDate,status)" +
                "values(:name,:description,:startDate,:endDate,:status)",
        resultClass = Project.class
)

@NamedNativeQuery(name = "deleteProjectById",
        query = "delete from project where id=:projectId ",
        resultClass = Project.class
)

@NamedNativeQuery(name = "updateProjectById",
        query = "update project" +
                "set name=:name,description:description,startDate=:startDate,endDate=:endDate,status=:status" +
                "where project.id =:projectId",
        resultClass = Project.class
)

public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String name;
    private String description;
    private Instant startDate;
    private Instant endDate;
    private Status status;

    @OneToMany(mappedBy = "project")
    private Set<Task> tasks;
}
