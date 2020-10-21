package com.example.app.service;

import com.example.app.entities.*;
import java.util.*;

/**
 *  Интерфейс для сервиса
 */
public interface ToDoService {

    /**
     * Создает новый список
     * @param toDoList - список для создания
     */
    void createList(ToDoLists toDoList);

    /**
     * Возвращает список всех списков
     * @return список списков
     */
    List<ToDoLists> getLists();

    /**
     * Возвращает список по его ID
     * @param id - ID списка
     * @return - объект списка с заданным ID
     */
    ToDoLists getTodoListById(UUID id);

    /**
     * Обновляет список с заданным ID,
     * в соответствии с переданным списком дел
     * @param toDoList - список дел в соответсвии с которым нужно обновить данные
     * @param id - id списка который нужно обновить
     * @return - true если данные были обновлены, иначе false
     */
    boolean updateTodoList(ToDoLists toDoList, UUID id);

    /**
     * Удаляет список с заданным ID
     * @param id - id списка, который нужно удалить
     * @return - true если список был удален, иначе false
     */
    boolean deleteTodoList(UUID id);

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
