package com.example.app;

import org.springframework.boot.builder.*;
import org.springframework.boot.web.servlet.support.*;

/**
 * Класс ServletInitializer расширяет класса SpringBootServletInitializer и позволяет нам настраивать наше приложение,
 * когда оно запускается контейнером сервлета, переопределяя метод configure ().
 * Этот метод использует SpringApplicationBuilder, чтобы просто зарегистрировать наш класс как класс конфигурации приложения
 */
public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ToDoListsApplication.class);
    }
}
