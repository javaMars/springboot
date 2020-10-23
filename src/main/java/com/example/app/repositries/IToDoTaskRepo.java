package com.example.app.repositries;

import com.example.app.entities.*;
import org.springframework.data.jpa.repository.*;

import java.util.*;

/**
 * Интерфейс для работы с таблицей ToDoTasks.
 */
public interface IToDoTaskRepo extends JpaRepository<ToDoTasks, Long> {

    /**
     * @param taskId
     * @return
     */
    ToDoTasks getByTaskId(UUID taskId);

    /**
     * @param taskId
     * @return
     */
    boolean existsByTaskId(UUID taskId);

    /**
     * @param taskId
     */
    void deleteByTaskId(UUID taskId);
}
