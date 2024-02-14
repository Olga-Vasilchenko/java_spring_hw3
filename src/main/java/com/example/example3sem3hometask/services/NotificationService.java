package com.example.example3sem3hometask.services;

import com.example.example3sem3hometask.domain.User;
import org.springframework.stereotype.Service;

@Service
public class NotificationService { // Класс консольных уведомлений

    public void notifyUser(User user) // Уведомление о создании нового пользователя
    {
        System.out.println("A new user has been created: " + user.getName());
    }

    public void sendNotification(String s) // Вывод уведомления в консоль
    {
        System.out.println(s);
    }
}
