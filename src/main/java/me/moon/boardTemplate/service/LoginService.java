package me.moon.boardTemplate.service;


public interface LoginService {
    void loginUser(String email);
    void logoutUser();
    String getCurrentUser();

}
