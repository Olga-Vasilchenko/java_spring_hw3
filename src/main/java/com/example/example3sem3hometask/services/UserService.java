package com.example.example3sem3hometask.services;

import com.example.example3sem3hometask.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService { // Класс создания пользователя
    @Autowired // Внедрение зависимости через конструктор не нужно, используем Autowired
    private NotificationService notificationService;

    // Метод для создания пользователя
    public User createUser(String name, int age, String email) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setEmail(email);

        // Отправляем уведомление о создании нового пользователя
        notificationService.notifyUser(user);
        return user;
    }
}
