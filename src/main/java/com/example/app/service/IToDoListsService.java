package com.example.app.service;

import com.example.app.entities.*;
import org.springframework.data.domain.Page;

import java.util.*;

/**
 *  Интерфейс для сервиса
 */
public interface IToDoListsService {

    /**
     * Создает новый список
     * @param toDoList - список для создания
     */
    void createList(ToDoLists toDoList);

    /**
     * Возвращает список всех списков
     * @return список списков
     */
    Page<ToDoLists> getLists(int page, int size, String filter, String sortBy, String sortDirection);

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
}
