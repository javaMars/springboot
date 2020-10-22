package com.example.app.controller;

import com.example.app.entities.*;
import com.example.app.impl.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 Компонент, который занимается обработкой сетевых запросов
 */
@RestController
public class ToDoListsController {

    private final ToDoListsServiceImpl toDoService;

    /**
     * В конструкторе внедряем зависимость
     * @param toDoService объект класса ToDoListsServiceImpl, реализующего интерфейс ToDoService
     */
    @Autowired
    public ToDoListsController(ToDoListsServiceImpl toDoService) {
        this.toDoService = toDoService;
    }

    /**
     * Метод для создания списка дел
     * @param toDoList - из тела запроса получаем список
     * @return - возвращает объект класса ResponseEntity для возврата ответов. С помощью него мы сможем в дальнейшем вернуть клиенту HTTP статус код.
     */
    @PostMapping(value = "/ToDoLists")
    public ResponseEntity<?> createList(@RequestBody ToDoLists toDoList) {
        toDoService.createList(toDoList);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Получаем список списков с фильтрацией, сортировкой и пагинацией
     * @return -  - возвращает объект класса ResponseEntity для возврата ответов. С помощью него мы сможем в дальнейшем вернуть клиенту HTTP статус код и список списков.
     */
    @GetMapping("/ToDoLists")
    public ResponseEntity<List<ToDoLists>> getLists() {
        final List<ToDoLists> toDoLists = toDoService.getLists();

        return toDoLists != null && !toDoLists.isEmpty()
                ? new ResponseEntity<>(toDoLists, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Получаем список дел по id
     * @param id - переменная пути, которая содержит id списка дел
     * @return  - возвращает объект класса ResponseEntity для возврата ответов. С помощью него мы сможем в дальнейшем вернуть клиенту HTTP статус код.
     */
    @GetMapping("/ToDoLists/{listId}")
    public ResponseEntity<ToDoLists> getTodoListById(@PathVariable(name = "listId") UUID id) {

        final ToDoLists toDoList = toDoService.getTodoListById(id);

        return toDoList != null
                ? new ResponseEntity<>(toDoList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Обновляем список дел по id
     * @param id - переменная пути, которая содержит id списка дел
     * @param toDoList - из тела запроса получаем список
     * @return - возвращает объект класса ResponseEntity для возврата ответов. С помощью него мы сможем в дальнейшем вернуть клиенту HTTP статус код.
     */
    @PutMapping(value = "/ToDoLists/{listId}")
    public ResponseEntity<?> updateToDoList(@PathVariable(name = "listId") UUID id, @RequestBody ToDoLists toDoList) {
        final boolean updated = toDoService.updateTodoList(toDoList, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    /**
     * Удаляем список дел по id
     * @param id  - переменная пути, которая содержит id списка дел
     * @return - возвращает объект класса ResponseEntity для возврата ответов. С помощью него мы сможем в дальнейшем вернуть клиенту HTTP статус код.
     */
    @DeleteMapping(value = "/ToDoLists/{listId}")
    public ResponseEntity<?> deleteToDoList(@PathVariable(name = "listId") UUID id) {
        final boolean deleted = toDoService.deleteTodoList(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
