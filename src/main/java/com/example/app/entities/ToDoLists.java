package com.example.app.entities;

import javax.persistence.*;
import java.util.*;

/**
 * Класс ToDoLists является сущностью, которая связана с таблицей todo_lists.
 */
@Entity
@Table(name = "todo_lists")
public class ToDoLists {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "list_id")
    private UUID listId;

    @Column(name = "created_datetime")
    private Date createdDateTime;

    @Column(name = "last_modified_datetime")
    private Date lastModifiedDateTime;

    @Column(name = "display_name", unique = true, nullable = false)
    private String displayName;

    /**
     * @return - дата создания списка дел
     */
    public Date getCreatedDateTime() {
        return createdDateTime;
    }

    /**
     * @param createdDateTime - дата создания списка дел
     */
    public void setCreatedDateTime(Date createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    /**
     * @return - дата изменения списка дел
     */
    public Date getLastModifiedDateTime() {
        return lastModifiedDateTime;
    }

    /**
     * @param lastModifiedDateTime - дата изменения списка дел
     */
    public void setLastModifiedDateTime(Date lastModifiedDateTime) {
        this.lastModifiedDateTime = lastModifiedDateTime;
    }

    /**
     * @return - идентификатор списка дел
     */
    public UUID getListId() {
        return listId;
    }

    /**
     * @param listId - идентификатор списка дел
     */
    public void setListId(UUID listId) {
        this.listId = listId;
    }

    /**
     * @return - название списка дел
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * @param displayName - название списка дел
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return "Список дел [id = " + listId + ", название = " + displayName +
                ", дата создания = " + createdDateTime + ", последние изменение = " + lastModifiedDateTime + "]";
    }
}
