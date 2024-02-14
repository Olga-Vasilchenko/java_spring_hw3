package com.example.example3sem3hometask.controllers;

import com.example.example3sem3hometask.domain.User;
import com.example.example3sem3hometask.services.RegistrationService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private RegistrationService service; //Сервис регистрации пользователей

    @GetMapping
    public List<User> userList() // Получение списка пользователей из репозитория
    {
        return service.getDataProcessingService().getRepository().getUsers();
    }

    @PostMapping("/body")
    public String userAddFromBody(@RequestBody Map<String, Object> requestBody) // Метод обработки POST-запросов, предназначенный для добавления нового пользователя
    {
        String name = (String) requestBody.get("name");
        Integer age = Integer.valueOf((String) requestBody.get("age"));
        String email = (String) requestBody.get("email");
        service.processRegistration(name, age, email);
        return "User added from body!";
    }
}
