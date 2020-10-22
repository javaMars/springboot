package com.example.app.impl;

import com.example.app.entities.*;
import com.example.app.repositries.*;
import com.example.app.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

/**
 * Реализация интерфейса ToDoService
 */
@Service
public class ToDoTasksServiceImpl implements ToDoTasksService {

    private final ToDoListsRepo toDoListsRepo;
    private final ToDoTaskRepo toDoTaskRepo;

    /**
     * @param toDoListsRepo - репозиторий для таблицы todoLists
     * @param toDoTaskRepo - репозиторий для таблиы toDoTasks
     */
    @Autowired
    public ToDoTasksServiceImpl(ToDoListsRepo toDoListsRepo, ToDoTaskRepo toDoTaskRepo) {
        this.toDoListsRepo = toDoListsRepo;
        this.toDoTaskRepo = toDoTaskRepo;
    }

    @Override
    public boolean createTask(ToDoTasks toDoTask, UUID listId) {
        if (toDoListsRepo.isExistsById(listId)) {
            toDoTask.setTodoListId(listId);
            toDoTaskRepo.save(toDoTask);
            return true;
        }
        return false;
    }

    @Override
    public ToDoTasks getTodoTaskById(UUID id) {
        return toDoTaskRepo.getOne(id);
    }

    @Override
    public boolean updateTodoTask(ToDoTasks toDoTask, UUID id) {
        if (toDoTaskRepo.isExistsById(id)) {
            toDoTask.setTaskId(id);
            toDoTaskRepo.save(toDoTask);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteTodoTask(UUID id) {
        if (toDoTaskRepo.isExistsById(id)) {
            toDoTaskRepo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean markDoneTodoTask(UUID id) {
        if (toDoTaskRepo.isExistsById(id)) {
            ToDoTasks toDoTask = toDoTaskRepo.getOne(id);
            toDoTask.setDone(true);
            toDoTaskRepo.save(toDoTask);
            return true;
        }
        return false;
    }

}
