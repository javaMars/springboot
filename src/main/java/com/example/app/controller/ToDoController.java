package com.example.app.controller;

import com.example.app.entities.*;
import com.example.app.repositries.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 Компонент, который занимается обработкой сетевых запросов
 */
@RestController
public class ToDoController {

    /**
     * Получаем список списков с фильтрацией, сортировкой и пагинацией
     * @return - наименование страницы, на которой будут отображены данные
     */
    @GetMapping("/ToDoLists")
    public String allLists(Model model) {
        //List<ToDoLists> toDoLists = toDoListsRepo.findAll();
        //model.addAttribute("toDoLists", toDoLists);

        return "index";
    }

    /**
     * @param model - модель, в которую будут добавляться данные для передачи в view
     * @param listId - идентификатор списка дел
     * @return - наименование страницы, на которой будут отображены данные
     */
    @GetMapping("/ToDoLists/{listId}")
    public String listById(Model model, @PathVariable Long listId) {
        //ToDoLists toDoList = toDoListsRepo.getOne(listId);
        //model.addAttribute("toDoList", toDoList);

        return "index";
    }

    /**
     * @param model - модель, в которую будут добавляться данные для передачи в view
     * @param taskId - идентификатор задачи
     * @return - наименование страницы, на которой будут отображены данные
     */
    @GetMapping("/ToDoTasks/{taskId}")
    public String taskById(Model model, @PathVariable Long taskId) {
       // ToDoTasks toDoTask = toDoTaskRepo.getOne(taskId);
       // model.addAttribute("toDoTask", toDoTask);

        return "tasks";
    }
}
