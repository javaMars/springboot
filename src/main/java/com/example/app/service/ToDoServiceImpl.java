package com.example.app.service;

import com.example.app.entities.*;
import com.example.app.repositries.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

/**
 * Реализация интерфейса ToDoService
 */
@Service
public class ToDoServiceImpl implements ToDoService{

    private final ToDoListsRepo toDoListsRepo;
    private final ToDoTaskRepo toDoTaskRepo;

    /**
     * @param toDoListsRepo - репозиторий для таблицы todoLists
     * @param toDoTaskRepo - репозиторий для таблиы toDoTasks
     */
    @Autowired
    public ToDoServiceImpl(ToDoListsRepo toDoListsRepo, ToDoTaskRepo toDoTaskRepo) {
        this.toDoListsRepo = toDoListsRepo;
        this.toDoTaskRepo = toDoTaskRepo;
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
        if (toDoListsRepo.isexistsById(id)) {
            toDoList.setListId(id);
            toDoListsRepo.save(toDoList);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteTodoList(UUID id) {
        if (toDoListsRepo.isexistsById(id)) {
            toDoListsRepo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public void createTask(ToDoTasks toDoTask) {
        toDoTaskRepo.save(toDoTask);
    }

    @Override
    public ToDoTasks getTodoTaskById(UUID id) {
        return toDoTaskRepo.getOne(id);
    }

    @Override
    public boolean updateTodoTask(ToDoTasks toDoTask, UUID id) {
        if (toDoTaskRepo.isexistsById(id)) {
            toDoTask.setTaskId(id);
            toDoTaskRepo.save(toDoTask);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteTodoTask(UUID id) {
        if (toDoTaskRepo.isexistsById(id)) {
            toDoTaskRepo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean markDoneTodoTask(UUID id) {
        if (toDoTaskRepo.isexistsById(id)) {
            ToDoTasks toDoTask = toDoTaskRepo.getOne(id);
            toDoTask.setDone(true);
            toDoTaskRepo.save(toDoTask);
            return true;
        }
        return false;
    }

}
