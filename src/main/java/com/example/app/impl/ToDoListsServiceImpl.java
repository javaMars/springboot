package com.example.app.impl;

import com.example.app.entities.*;
import com.example.app.repositries.*;
import com.example.app.service.IToDoListsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Реализация интерфейса ToDoService
 */
@Service
public class ToDoListsServiceImpl implements IToDoListsService {

    private final IToDoListsRepo toDoListsRepo;

    /**
     * @param toDoListsRepo - репозиторий для таблицы todoLists
     */
    @Autowired
    public ToDoListsServiceImpl(IToDoListsRepo toDoListsRepo) {
        this.toDoListsRepo = toDoListsRepo;
    }

    @Override
    public void createList(ToDoLists toDoList) {
        toDoListsRepo.save(toDoList);
    }

    @Override
    public Page<ToDoLists> getLists(int page, int size, String filter, String sortBy, String sortDirection){

        if ("desc".equals(sortDirection)) {
            return toDoListsRepo.findAll(PageRequest.of(page, size, Sort.by(sortBy).descending()));
        } else {
            return toDoListsRepo.findAll(PageRequest.of(page, size, Sort.by(sortBy).ascending()));
        }
    }

    @Override
    public ToDoLists getTodoListById(UUID id) {
        return toDoListsRepo.getByListId(id);
    }

    @Override
    public boolean updateTodoList(ToDoLists toDoList, UUID id) {
        if (toDoListsRepo.existsToDoListsByListId(id)) {
            toDoList.setListId(id);
            toDoListsRepo.save(toDoList);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteTodoList(UUID id) {
        if (toDoListsRepo.existsToDoListsByListId(id)) {
            toDoListsRepo.deleteToDoListsByListId(id);
            return true;
        }
        return false;
    }
}
