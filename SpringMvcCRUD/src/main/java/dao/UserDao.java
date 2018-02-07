package dao;

import model.User;

import java.util.List;

public interface UserDao {
    public List<User> listAllUsers();
    public void addUser(User user);
    public void deleteUser(int id);
    public void updateUser(User user);
    public User findUserById(int id);
}
