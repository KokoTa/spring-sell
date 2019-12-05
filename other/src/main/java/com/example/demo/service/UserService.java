package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Users;

/**
 * UserService
 */
public interface UserService {

  public void saveUser(Users user);

  public void updateUser(Users user);

  public void deleteUser(Users user);

  public Users findUserById(String id);

  public List<Users> findUserList(Users user, Integer page, Integer pageSize);

  public Users findCustomeOne(String id);

}