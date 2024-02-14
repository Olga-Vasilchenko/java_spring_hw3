package com.example.example3sem3hometask.domain;

/** Seminar 3
 Создать два сервиса - "UserService" и "NotificationService". UserService должен
 содержать метод createUser(String name, int age, String email), который создает
 пользователя и возвращает его. NotificationService должен иметь метод
 notifyUser(User user), который просто печатает сообщение о том, что
 пользователь был создан. Ваша задача - использовать @Autowired в
 UserService для внедрения NotificationService и вызвать метод notifyUser после
 создания нового пользователя.
*/

public class User {
    private int id;
    private String name;
    private int age;
    private String email;

    public User(){
    }

    // Геттеры и сеттеры
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
