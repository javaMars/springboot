package com.example.app.repositries;

import com.example.app.entities.*;
import org.springframework.data.jpa.repository.*;

import java.util.*;

/**
 * Интерфейс для работы с таблицей ToDoTasks.
 */
public interface ToDoTaskRepo extends JpaRepository<ToDoTasks, Long> {

    ToDoTasks getOne(UUID id);

    boolean isexistsById(UUID id);

    void deleteById(UUID id);
}
