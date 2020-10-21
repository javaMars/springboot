package com.example.app.repositries;

import com.example.app.entities.*;
import org.springframework.data.jpa.repository.*;

/**
 * Интерфейс для работы с данными таблицы списка дел ToDoLists
 */
public interface ToDoListsRepo extends JpaRepository<ToDoLists, Long> {

}
