package com.example.app.service;

import com.example.app.entities.*;

import java.util.*;

/**
 *  Интерфейс для сервиса
 */
public interface ToDoTasksService {

    /**
     * Создает новую задачу
     * @param toDoTask - задача для создания
     */
    boolean createTask(ToDoTasks toDoTask, UUID listId);

    /**
     * Возвращает задачу по его ID
     * @param id - ID задачи
     * @return - объект задача с заданным ID
     */
    ToDoTasks getTodoTaskById(UUID id);

    /**
     * Обновляет задачу с заданным ID,
     * в соответствии с переданной задачей
     * @param toDoTask - задача в соответсвии с которой нужно обновить данные
     * @param id - id задачи которую нужно обновить
     * @return - true если данные были обновлены, иначе false
     */
    boolean updateTodoTask(ToDoTasks toDoTask, UUID id);

    /**
     * Удаляет задачу с заданным ID
     * @param id - id задачи, которую нужно удалить
     * @return - true если задача была удалена, иначе false
     */
    boolean deleteTodoTask(UUID id);

    /**
     * Ставит метку "Выполнено" для задачи
     * @param id - id задачи, которую нужно обновить
     * @return - true если данные были обновлены, иначе false
     */
    boolean markDoneTodoTask(UUID id);
}
