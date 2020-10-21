package com.example.app;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;

/**
 * Основной класс нашего приложения
 */
@SpringBootApplication
public class ToDoListsApplication {

    /**
     * В методе main используется метод SpringApplication.run()
     * для запуска приложения.
     * @param args аргументы, которые были переданы нашему приложению из командной строки
     */
    public static void main(String[] args) {
        SpringApplication.run(ToDoListsApplication.class, args);
    }
}
