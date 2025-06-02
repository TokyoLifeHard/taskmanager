package ru.tokyolifehard.taskmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskmanagerApplication {
//todo Переделать запросы, добвать джоины + добавть в dto результаты join сущностей
//todo Решить проблему patch метода
//todo Реализовать мапперы
//todo Реализовать бизнес исключения
//todo Реализовать логгирование
//todo Реализовать сервис нотификаций
//todo Реализовать сервис нотификаций

	public static void main(String[] args) {
		SpringApplication.run(TaskmanagerApplication.class, args);
	}

}
