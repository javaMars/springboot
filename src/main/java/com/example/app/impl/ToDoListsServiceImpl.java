package com.example.app.impl;

import com.example.app.entities.*;
import com.example.app.repositries.*;
import com.example.app.service.ToDoListsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Реализация интерфейса ToDoService
 */
@Service
public class ToDoListsServiceImpl implements ToDoListsService {

    private final ToDoListsRepo toDoListsRepo;

    /**
     * @param toDoListsRepo - репозиторий для таблицы todoLists
     */
    @Autowired
    public ToDoListsServiceImpl(ToDoListsRepo toDoListsRepo) {
        this.toDoListsRepo = toDoListsRepo;
    }

    @Override
    public void createList(ToDoLists toDoList) {
        toDoListsRepo.save(toDoList);
    }

    @Override
    public List<ToDoLists> getLists() {
        return toDoListsRepo.findAll();
    }

    @Override
    public ToDoLists getTodoListById(UUID id) {
        return toDoListsRepo.getOne(id);
    }

    @Override
    public boolean updateTodoList(ToDoLists toDoList, UUID id) {
        if (toDoListsRepo.isExistsById(id)) {
            toDoList.setListId(id);
            toDoListsRepo.save(toDoList);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteTodoList(UUID id) {
        if (toDoListsRepo.isExistsById(id)) {
            toDoListsRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
