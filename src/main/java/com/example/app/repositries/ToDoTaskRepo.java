package com.example.app.repositries;

import com.example.app.entities.*;
import org.springframework.data.jpa.repository.*;

import java.util.*;

/**
 * Интерфейс для работы с таблицей ToDoTasks.
 */
public interface ToDoTaskRepo extends JpaRepository<ToDoTasks, Long> {

    /**
     * @param id
     * @return
     */
    ToDoTasks getOne(UUID id);

    /**
     * @param id
     * @return
     */
    boolean isExistsById(UUID id);

    /**
     * @param id
     */
    void deleteById(UUID id);
}
