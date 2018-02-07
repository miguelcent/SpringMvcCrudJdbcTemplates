package service;

import java.util.List;

import model.User;

public interface UserService {
    public List<User> listAllUsers();
    public void addUser(User user);
    public void deleteUser(int id);
    public void updateUser(User user);
    public User findUserById(int id);
}
