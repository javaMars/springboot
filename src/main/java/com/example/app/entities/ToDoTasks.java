package com.example.app.entities;

import javax.persistence.*;
import java.util.*;

/**
 * Класс ToDoTasks является сущностью, которая связана с таблицей todo_tasks.
 */
@Entity
@Table(name = "todo_tasks")
public class ToDoTasks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private UUID taskId;

    @Column(name = "todo_list_id", nullable = false)
    private UUID todoListId;

    @Column(name = "created_datetime")
    private Date createdDateTime;

    @Column(name = "last_modified_datetime")
    private Date lastModifiedDateTime;

    @Column(name = "title", unique = true, nullable = false)
    private String title;

    @Column(name = "body")
    private String body;

    @Column(name = "importance")
    private int importance;

    @Column(name = "done")
    private Boolean done;
/*
    /**
     * Конструктор по умолчанию
     */
/*
    public ToDoTasks() {
        todoListId = 0;
        createdDateTime = new Date();
        lastModifiedDateTime = new Date();
        title = "";
        body = "";
        importance = 1;
        taskId = 0;
        done = false;
    }
/*
    /**
     * @param todoListId идентификатор списка дел, к которому относится задача
     * @param createdDateTime время создания задачи
     * @param lastModifiedDateTime время изменения задачи
     * @param title название задачи
     * @param body краткое описание задачи
     * @param importance срочность задачи
     */
 /*   public ToDoTasks(int todoListId, Date createdDateTime, Date lastModifiedDateTime, String title, String body, int importance) {
        this.todoListId = todoListId;
        this.createdDateTime = createdDateTime;
        this.lastModifiedDateTime = lastModifiedDateTime;
        this.title = title;
        this.body = body;
        this.importance = importance;
        taskId = 0;
        done = false;
    }
*/
    /**
     * @return - возвращает значение метки "Выполнено" для задачи
     */
    public Boolean isDone() {
        return done;
    }

    /**
     * @param done - метка "Выполнено" для задачи
     */
    public void setDone(Boolean done) {
        this.done = done;
    }

    /**
     * @return - дата создания задачи
     */
    public Date getCreatedDateTime() {
        return createdDateTime;
    }

    /**
     * @param createdDateTime - дата создания задачи
     */
    public void setCreatedDateTime(Date createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    /**
     * @return - дата изменения задачи
     */
    public Date getLastModifiedDateTime() {
        return lastModifiedDateTime;
    }

    /**
     * @param lastModifiedDateTime - дата изменения задачи
     */
    public void setLastModifiedDateTime(Date lastModifiedDateTime) {
        this.lastModifiedDateTime = lastModifiedDateTime;
    }

    /**
     * @return - срочность задачи
     */
    public int getImportance() {
        return importance;
    }

    /**
     * @param importance - срочность задачи
     */
    public void setImportance(int importance) {
        this.importance = importance;
    }

    /**
     * @return - идентификатор задачи
     */
    public UUID getTaskId() {
        return taskId;
    }

    /**
     * @param taskId - идентификатор задачи
     */
    public void setTaskId(UUID taskId) {
        this.taskId = taskId;
    }

    /**
     * @return - идентификатор списка, к которому относится задача
     */
    public UUID getTodoListId() {
        return todoListId;
    }

    /**
     * @param todoListId - идентификатор списка, к которому относится задача
     */
    public void setTodoListId(UUID todoListId) {
        this.todoListId = todoListId;
    }

    /**
     * @return - краткое описание задачи
     */
    public String getBody() {
        return body;
    }

    /**
     * @param body - краткое описание задачи
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * @return - название задачи
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title - название задачи
     */
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Задача [id = " + taskId + ", todoListId = " + todoListId + ", название = " + title + ", краткое описание = " + body +
                ", дата создания = " + createdDateTime + ", последние изменение = " + lastModifiedDateTime + ", срочность = " + importance +
                ", метка Выполнено = " + done + "]";
    }

}
