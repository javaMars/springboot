package com.example.app.controller;

import com.example.app.entities.*;
import com.example.app.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 Компонент, который занимается обработкой сетевых запросов
 */
@RestController
public class ToDoController {

    private final ToDoService toDoService;

    /**
     * В конструкторе внедряем зависимость
     * @param toDoService интерфейс ToDoService
     */
    @Autowired
    public ToDoController(ToDoService toDoService) {
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

    /**
     * Получаем задачу по id
     * @param id  - переменная пути, которая содержит id задачи
     * @return - возвращает объект класса ResponseEntity для возврата ответов. С помощью него мы сможем в дальнейшем вернуть клиенту HTTP статус код и задачу.
     */
    @GetMapping("/ToDoTasks/{taskId}")
    public ResponseEntity<ToDoTasks> getTodoTaskById(@PathVariable(name = "taskId") UUID id) {
        final ToDoTasks toDoTask = toDoService.getTodoTaskById(id);

        return toDoTask != null
                ? new ResponseEntity<>(toDoTask, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Создаем задачу для конкретного списка дел(получаем список по id)
     * @param toDoTask - из тела запроса получаем задачу
     * @param listId - переменная пути, которая содержит id списка дел
     * @return - возвращает объект класса ResponseEntity для возврата ответов. С помощью него мы сможем в дальнейшем вернуть клиенту HTTP статус код.
     */
    @PostMapping(value = "/ToDoLists/{listId}/ToDoTasks")
    public ResponseEntity<?> createTask(@RequestBody ToDoTasks toDoTask, @PathVariable(name = "listId") UUID listId) {
        final boolean created = toDoService.createTask(toDoTask, listId);
        return created
                ? new ResponseEntity<>(HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    /**
     * Обновляем задачу по id
     * @param id - переменная пути, которая содержит id задачи
     * @param toDoTask - из тела запроса получаем задачу
     * @return - возвращает объект класса ResponseEntity для возврата ответов. С помощью него мы сможем в дальнейшем вернуть клиенту HTTP статус код.
     */
    @PutMapping(value = "/ToDoTasks/{taskId}")
    public ResponseEntity<?> updateToDoTask(@PathVariable(name = "taskId") UUID id, @RequestBody ToDoTasks toDoTask) {
        final boolean updated = toDoService.updateTodoTask(toDoTask, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    /**
     * Удаляем задачу по id
     * @param id - переменная пути, которая содержит id задачи
     * @return - возвращает объект класса ResponseEntity для возврата ответов. С помощью него мы сможем в дальнейшем вернуть клиенту HTTP статус код.
     */
    @DeleteMapping(value = "/ToDoTasks/{taskId}")
    public ResponseEntity<?> deleteToDoTask(@PathVariable(name = "taskId") UUID id) {
        final boolean deleted = toDoService.deleteTodoTask(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    /**
     * Ставим метку "Выполнено" для задачи
     * @param id - переменная пути, которая содержит id задачи
     * @return - возвращает объект класса ResponseEntity для возврата ответов. С помощью него мы сможем в дальнейшем вернуть клиенту HTTP статус код.
     */
    @PutMapping(value = "/ToDoTasks/markDone/{taskId}")
    public ResponseEntity<?> markDoneTodoTask(@PathVariable(name = "taskId") UUID id) {
        final boolean updated = toDoService.markDoneTodoTask(id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

}
