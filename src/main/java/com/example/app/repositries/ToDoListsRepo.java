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
    boolean isexistsById(UUID id);

    void deleteById(UUID id);

    ToDoLists getOne(UUID id);
}


