package ru.tokyolifehard.taskmanager.utils;

import org.springframework.stereotype.Component;
import ru.tokyolifehard.taskmanager.dto.TaskDTO;

import java.lang.reflect.Field;

@Component
public class TaskDTOPatcher {
    public static void patch(TaskDTO income,TaskDTO exists) throws IllegalAccessException {
        Class<?> taskDtoClazz = TaskDTO.class;
        Field[] declaredFields = taskDtoClazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            Object value = declaredField.get(income);
            if(value!=null){
                declaredField.set(exists,value);
            }
            declaredField.setAccessible(false);
        }
    }

}
