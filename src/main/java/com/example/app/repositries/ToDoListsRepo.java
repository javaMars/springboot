package com.example.app.repositries;

import com.example.app.entities.*;
import org.springframework.data.jpa.repository.*;

import java.util.*;

/**
 * Интерфейс для работы с данными таблицы списка дел ToDoLists
 */
public interface ToDoListsRepo extends JpaRepository<ToDoLists, Long> {

    /**
     * @param id
     * @return
     */
    boolean isExistsById(UUID id);

    /**
     * @param id
     */
    void deleteById(UUID id);

    /**
     * @param id
     * @return
     */
    ToDoLists getOne(UUID id);
}


