package ru.tokyolifehard.taskmanager.repository;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.tokyolifehard.taskmanager.dto.ProjectDTO;
import ru.tokyolifehard.taskmanager.entity.Project;

@Repository
public class ProjectRepository {
    private final SessionFactory projectSessionFactory;

    public ProjectRepository(SessionFactory projectSessionFactory) {
        this.projectSessionFactory = projectSessionFactory;
    }

    public Project getProjectById(Long id){
        Project project = this.projectSessionFactory.getCurrentSession()
                .createNamedQuery("getProjectById", Project.class)
                .setParameter("projectId", id)
                .list()
                .getFirst();
        this.projectSessionFactory.getCurrentSession().close();
        return project;
    }

    public void createProject(ProjectDTO projectDTO){
        this.projectSessionFactory.getCurrentSession()
                .createNamedQuery("createProject", Project.class)
                .setParameter("name", projectDTO.getName())
                .setParameter("description", projectDTO.getDescription())
                .setParameter("startDate", projectDTO.getStartDate())
                .setParameter("endDate", projectDTO.getEndDate())
                .setParameter("status", projectDTO.getStatus())
                .executeUpdate();
        this.projectSessionFactory.getCurrentSession().close();
    }

    public void deleteProjectById(Long id){
        this.projectSessionFactory.getCurrentSession()
                .createNamedQuery("deleteProjectById", Project.class)
                .setParameter("projectId",id)
                .executeUpdate();
        this.projectSessionFactory.getCurrentSession().close();
    }

    public void updateProjectById(Long id,ProjectDTO projectDTO){
        this.projectSessionFactory.getCurrentSession()
                .createNamedQuery("createProject", Project.class)
                .setParameter("name", projectDTO.getName())
                .setParameter("description", projectDTO.getDescription())
                .setParameter("startDate", projectDTO.getStartDate())
                .setParameter("endDate", projectDTO.getEndDate())
                .setParameter("status", projectDTO.getStatus())
                .setParameter("projectId",id)
                .executeUpdate();
        this.projectSessionFactory.getCurrentSession().close();
    }
}
