

-- Вставка пользователей
INSERT INTO appuser (id, username, email, password, createdtime) VALUES (1, 'alex_ivanov', 'alex@company.com', '5f4dcc3b5aa765d61d8327deb882cf99', '2024-01-15 09:00:00');
INSERT INTO appuser (id, username, email, password, createdtime) VALUES (2, 'mariya_sidorova', 'mariya@company.com', '6cb75f652a9b52798eb6cf2201057c73', '2024-01-16 10:30:00');
INSERT INTO appuser (id, username, email, password, createdtime) VALUES (3, 'dmitry_petrov', 'dmitry@company.com', '96e79218965eb72c92a549dd5a330112', '2024-01-17 14:15:00');
INSERT INTO appuser (id, username, email, password, createdtime) VALUES (4, 'olga_kuznetsova', 'olga@company.com', 'd8578edf8458ce06fbc5bb76a58c5ca4', '2024-02-01 11:20:00');
INSERT INTO appuser (id, username, email, password, createdtime) VALUES (5, 'ivan_vorobev', 'ivan@company.com', 'e10adc3949ba59abbe56e057f20f883e', '2024-02-05 16:45:00');

-- Вставка проектов
INSERT INTO project (id, name, description, startdate, enddate, status) VALUES (1, 'Web Portal', 'Корпоративный портал для сотрудников', '2024-02-01 00:00:00', '2024-06-30 23:59:59', 'IN_PROGRESS');
INSERT INTO project (id, name, description, startdate, enddate, status) VALUES (2, 'Mobile Banking', 'Мобильное приложение для клиентов', '2024-03-10 00:00:00', '2024-09-15 23:59:59', 'CREATED');
INSERT INTO project (id, name, description, startdate, enddate, status) VALUES (3, 'Database Migration', 'Перенос данных на PostgreSQL', '2024-01-20 00:00:00', '2024-05-31 23:59:59', 'SUSPENDED');
INSERT INTO project (id, name, description, startdate, enddate, status) VALUES (4, 'API Gateway', 'Единая точка входа для микросервисов', '2024-03-01 00:00:00', '2024-08-31 23:59:59', 'IN_PROGRESS');
INSERT INTO project (id, name, description, startdate, enddate, status) VALUES (5, 'Analytics Dashboard', 'Панель бизнес-аналитики', '2024-02-15 00:00:00', '2024-07-15 23:59:59', 'CREATED');

-- Вставка задач
-- Проект 1 (Web Portal)
INSERT INTO task (title, description, status, priority, duedate, createdat, updatedat, user_id, project_id) VALUES ('Дизайн главной', 'Создать UI/UX главной страницы', 'IN_PROGRESS', 'MID', '2024-02-28 18:00:00', '2024-02-01 10:00:00', '2024-02-01 10:00:00', 1, 1);
INSERT INTO task (title, description, status, priority, duedate, createdat, updatedat, user_id, project_id) VALUES ('Авторизация', 'Реализовать OAuth2 аутентификацию', 'CREATED', 'MAX', '2024-04-15 12:00:00', '2024-02-10 14:30:00', '2024-02-10 14:30:00', 2, 1);
INSERT INTO task (title, description, status, priority, duedate, createdat, updatedat, user_id, project_id) VALUES ('Тестирование', 'Нагрузочное тестирование сервиса', 'IN_PROGRESS', 'MID', '2024-03-15 14:00:00', '2024-02-05 13:15:00', '2024-02-10 08:45:00', 3, 1);

-- Проект 2 (Mobile Banking)
INSERT INTO task (title, description, status, priority, duedate, createdat, updatedat, user_id, project_id) VALUES ('Push-уведомления', 'Интеграция с Firebase Cloud Messaging', 'CREATED', 'MAX', '2024-05-20 16:00:00', '2024-03-12 09:15:00', '2024-03-12 09:15:00', 4, 2);
INSERT INTO task (title, description, status, priority, duedate, createdat, updatedat, user_id, project_id) VALUES ('Биометрия', 'Добавить вход по отпечатку пальца', 'SUSPENDED', 'MID', '2024-07-31 17:30:00', '2024-03-15 11:20:00', '2024-04-01 10:10:00', 5, 2);
INSERT INTO task (title, description, status, priority, duedate, createdat, updatedat, user_id, project_id) VALUES ('Онлайн-чат', 'Чат с поддержкой внутри приложения', 'IN_PROGRESS', 'LOW', '2024-08-15 13:45:00', '2024-03-20 14:00:00', '2024-03-25 16:30:00', 1, 2);

-- Проект 3 (Database Migration)
INSERT INTO task (title, description, status, priority, duedate, createdat, updatedat, user_id, project_id) VALUES ('Резервное копирование', 'Настроить ежедневные бэкапы', 'CLOSED', 'MAX', '2024-02-10 12:00:00', '2024-01-21 14:20:00', '2024-02-11 09:00:00', 2, 3);
INSERT INTO task (title, description, status, priority, duedate, createdat, updatedat, user_id, project_id) VALUES ('Перенос данных', 'Миграция 10TB данных', 'SUSPENDED', 'MAX', '2024-03-31 17:00:00', '2024-01-25 10:45:00', '2024-02-28 14:15:00', 3, 3);
INSERT INTO task (title, description, status, priority, duedate, createdat, updatedat, user_id, project_id) VALUES ('Оптимизация', 'Тюнинг производительности запросов', 'CREATED', 'MID', '2024-05-15 15:20:00', '2024-02-01 16:30:00', '2024-02-01 16:30:00', 4, 3);

-- Проект 4 (API Gateway)
INSERT INTO task (title, description, status, priority, duedate, createdat, updatedat, user_id, project_id) VALUES ('Rate Limiting', 'Настройка ограничений запросов', 'IN_PROGRESS', 'MAX', '2024-04-30 11:30:00', '2024-03-05 09:00:00', '2024-03-15 12:40:00', 5, 4);
INSERT INTO task (title, description, status, priority, duedate, createdat, updatedat, user_id, project_id) VALUES ('Документация', 'Генерация Swagger UI', 'CREATED', 'LOW', '2024-06-15 14:00:00', '2024-03-10 13:20:00', '2024-03-10 13:20:00', 1, 4);
INSERT INTO task (title, description, status, priority, duedate, createdat, updatedat, user_id, project_id) VALUES ('Мониторинг', 'Интеграция с Prometheus', 'IN_PROGRESS', 'MID', '2024-05-31 18:45:00', '2024-03-15 15:10:00', '2024-03-20 11:25:00', 2, 4);

-- Проект 5 (Analytics Dashboard)
INSERT INTO task (title, description, status, priority, duedate, createdat, updatedat, user_id, project_id) VALUES ('Виджеты', 'Разработка модуля виджетов', 'CREATED', 'MID', '2024-06-01 10:00:00', '2024-02-20 11:30:00', '2024-02-20 11:30:00', 3, 5);
INSERT INTO task (title, description, status, priority, duedate, createdat, updatedat, user_id, project_id) VALUES ('Экспорт в PDF', 'Реализовать экспорт отчетов', 'IN_PROGRESS', 'LOW', '2024-05-15 16:20:00', '2024-03-01 14:50:00', '2024-03-10 09:15:00', 4, 5);
INSERT INTO task (title, description, status, priority, duedate, createdat, updatedat, user_id, project_id) VALUES ('Интеграция с CRM', 'Подключение к Salesforce API', 'SUSPENDED', 'MAX', '2024-07-01 13:00:00', '2024-03-05 10:40:00', '2024-03-15 17:00:00', 5, 5);