package com.example.example3sem3hometask.services;

import com.example.example3sem3hometask.domain.User;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService { // Класс регистрации новых пользователей

    private final DataProcessingService dataProcessingService; // Поле сервиса работы с хранилищем пользователей

    private final UserService userService; // Поле сервиса создания пользователей

    private final NotificationService notificationService; // Поле сервиса консольных уведомлений

    // Конструктор класса
    public RegistrationService(DataProcessingService dataProcessingService,
                               UserService userService,
                               NotificationService notificationService) {
        this.dataProcessingService = dataProcessingService;
        this.userService = userService;
        this.notificationService = notificationService;
    }

    // Метод сохранения пользователя в БД
    public void processRegistration(String name, int age, String email){
        User createUser = userService.createUser(name, age, email);
        dataProcessingService.addUser(createUser);
        notificationService.sendNotification("Пользователь сохранен в БД");
    }

    // Получение сервиса работы с хранилищем пользователей
    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }
}
