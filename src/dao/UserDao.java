package dao;

import model.User;
import service.Persistence;

import java.util.ArrayList;

public class UserDao implements Dao<User> {
    @Override
    public void insert(User user) {
        Persistence.user = user;
    }

    @Override
    public void remove(User user) {

    }

    @Override
    public void alter(User oldValue, User newValue) {

    }

    @Override
    public User getItem(String[] args) {
        return null;
    }

    @Override
    public ArrayList<User> getList(String[] args) {
        return null;
    }
}
