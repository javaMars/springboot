package com.example.app.repositries;

import com.example.app.entities.*;
import org.springframework.data.jpa.repository.*;

/**
 * Интерфейс для работы с таблицей ToDoTasks.
 */
public interface ToDoTaskRepo extends JpaRepository<ToDoTasks, Long> {

}
