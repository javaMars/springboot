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
public class ToDoTasksServiceImpl implements IToDoTasksService {

    private final IToDoListsRepo toDoListsRepo;
    private final IToDoTaskRepo toDoTaskRepo;

    /**
     * @param toDoListsRepo - репозиторий для таблицы todoLists
     * @param toDoTaskRepo - репозиторий для таблиы toDoTasks
     */
    @Autowired
    public ToDoTasksServiceImpl(IToDoListsRepo toDoListsRepo, IToDoTaskRepo toDoTaskRepo) {
        this.toDoListsRepo = toDoListsRepo;
        this.toDoTaskRepo = toDoTaskRepo;
    }

    @Override
    public boolean createTask(ToDoTasks toDoTask, UUID listId) {
        if (toDoListsRepo.existsToDoListsByListId(listId)) {
            toDoTask.setTodoListId(listId);
            toDoTaskRepo.save(toDoTask);
            return true;
        }
        return false;
    }

    @Override
    public ToDoTasks getTodoTaskById(UUID id) {
        return toDoTaskRepo.getByTaskId(id);
    }

    @Override
    public boolean updateTodoTask(ToDoTasks toDoTask, UUID id) {
        if (toDoTaskRepo.existsByTaskId(id)) {
            toDoTask.setTaskId(id);
            toDoTaskRepo.save(toDoTask);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteTodoTask(UUID id) {
        if (toDoTaskRepo.existsByTaskId(id)) {
            toDoTaskRepo.deleteByTaskId(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean markDoneTodoTask(UUID id) {
        if (toDoTaskRepo.existsByTaskId(id)) {
            ToDoTasks toDoTask = toDoTaskRepo.getByTaskId(id);
            toDoTask.setDone(true);
            toDoTaskRepo.save(toDoTask);
            return true;
        }
        return false;
    }

}
