package com.lyonbank.LyonBank.dao;

import com.lyonbank.LyonBank.models.User;

import java.util.List;

public interface UserDao {
    List<User> getUsers();

    void delete(Long id);

    void register(User user);
}
