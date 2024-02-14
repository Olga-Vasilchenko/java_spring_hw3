package com.example.example3sem3hometask.services;

import com.example.example3sem3hometask.domain.User;
import com.example.example3sem3hometask.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataProcessingService { // Класс, обеспечивающий работу с хранилищем данных пользователей
    @Autowired
    private UserRepository repository; // Поле с репозиторием пользователей

    // Получение репозитория пользователей
    public UserRepository getRepository() {
        return repository;
    }

    // Сортировка пользователей по возрасту
    public List<User> sortUsersByAge(List<User> users) {
        return users.stream()
                .sorted(Comparator.comparing(User::getAge))
                .collect(Collectors.toList());
    }

    // Фильтрация списка пользователей по возрасту
    public List<User> filterUsersByAge(List<User> users, int age){
        return users.stream()
                .filter(user -> user.getAge() > age)
                .collect(Collectors.toList());
    }
    // Метод вычисляет средний возраст пользователей
    public double calculateAverageAge(List<User> users){
        return users.stream()
                .mapToInt(User::getAge)
                .average()
                .orElse(0);
    }

    // Добавление пользователя в БД
    public void addUser(User user) {
        repository.getUsers().add(user);
//        repository.addUser(user);
    }



}
