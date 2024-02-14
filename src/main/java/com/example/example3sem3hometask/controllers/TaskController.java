package com.example.example3sem3hometask.controllers;

import com.example.example3sem3hometask.domain.User;
import com.example.example3sem3hometask.services.DataProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController { // Класс, реализующий методы работы с информацией в базе данных
    @Autowired
    private DataProcessingService service; // Сервис обработки задач

    @GetMapping
    public List<String> getAllTasks() // Метод вывода всех поддерживаемых задач
    {
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calc");
        return tasks; // Возвращает список задач
    }

    @GetMapping("/sort")//localhost:8080/tasks/sort
    public List<User> sortUsersByAge() // Получение списка пользователей отсортированных по возрасту
    {
        return service.sortUsersByAge(service.getRepository().getUsers());
    }

    //метод filterUsersByAge
    @GetMapping("/filter/{age}") // Фильтрация по возрасту. Получение списка пользователей старше заданного возраста
    public List<User> filterUsersByAge(@PathVariable("age") int age){
        List<User> users = service.getRepository().getUsers();
        return service.filterUsersByAge(users, age);
    }

    //метод calculateAverageAge
    @GetMapping("/calc") // Получение среднего возраста пользователей
    public double calculateAverageAge(){
        List<User> users = service.getRepository().getUsers();
        return service.calculateAverageAge(users);
    }
}
