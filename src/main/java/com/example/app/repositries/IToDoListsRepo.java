package com.example.app.repositries;

import com.example.app.entities.*;
import org.springframework.data.jpa.repository.*;

import java.util.*;

/**
 * Интерфейс для работы с данными таблицы списка дел ToDoLists
 */
public interface IToDoListsRepo extends JpaRepository<ToDoLists, Long> {

    /**
     * @param listId
     * @return
     */
    boolean existsToDoListsByListId(UUID listId);

    /**
     * @param listId
     */
    void deleteToDoListsByListId(UUID listId);

    /**
     * @param listId
     * @return
     */
    ToDoLists getByListId(UUID listId);
}


