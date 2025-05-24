package ru.tokyolifehard.taskmanager.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.tokyolifehard.taskmanager.dto.TaskDTO;
import ru.tokyolifehard.taskmanager.entity.Priority;
import ru.tokyolifehard.taskmanager.entity.Status;
import ru.tokyolifehard.taskmanager.entity.Task;

import java.time.Instant;

@Repository
public class TaskRepository {

    private final SessionFactory taskSessionFactory;

    public TaskRepository(SessionFactory taskSessionFactory) {
        this.taskSessionFactory = taskSessionFactory;
    }

    public Task getTaskById(Long id){
        Task task = this.taskSessionFactory.getCurrentSession()
                .createNativeQuery("select * from task where id =:id", Task.class)
                .setParameter(0, id)
                .list()
                .get(0);
        this.taskSessionFactory.getCurrentSession().close();

        return task;
    }

    public void createTask(TaskDTO taskDTO){
        this.taskSessionFactory.getCurrentSession()
                .createNativeQuery("insert into task(title,description,status,priority,dueDate,createdAt,updatedAt) " +
                        "values(?,?,?,?,?,?,?)",Task.class)
                .setParameter(2,taskDTO.getTitle())
                .setParameter(3,taskDTO.getDescription())
                .setParameter(4, Status.CREATED)
                .setParameter(5, taskDTO.getPriority())
                .setParameter(6, Instant.now())
                .setParameter(7, taskDTO.getCreatedAt())
                .setParameter(8, taskDTO.getLeadTime())
                .executeUpdate();

        this.taskSessionFactory.getCurrentSession().close();
    }

    public void deleteTaskById(Long taskId){
        this.taskSessionFactory.getCurrentSession()
                .createNativeQuery("delete from task where id=:id",Task.class)
                .setParameter("id",taskId)
                .executeUpdate();

        this.taskSessionFactory.getCurrentSession().close();
    }

    public void updateTaskById(Long taskId){
        this.taskSessionFactory.getCurrentSession()
                .createNativeQuery("delete from task where id=:id",Task.class)
                .setParameter("id",taskId)
                .executeUpdate();

        this.taskSessionFactory.getCurrentSession().close();
    }

    public void updateTaskById(Long taskId,TaskDTO taskDTO){
        this.taskSessionFactory.getCurrentSession()
                .createNativeQuery("update task " +
                        "set title=:title,description=:description,status=:status,priority=:priority,dueDate=:dueDate,updatedAt=:updatedAt) " +
                        "where id=id",Task.class)
                .setParameter("title",taskDTO.getTitle())
                .setParameter("description",taskDTO.getDescription())
                .setParameter("status", Status.CREATED)
                .setParameter("priority", taskDTO.getPriority())
                .setParameter("dueDate", taskDTO.getCreatedAt())
                .setParameter("updatedAt", taskDTO.getLeadTime())
                .executeUpdate();

        this.taskSessionFactory.getCurrentSession().close();
    }
}
