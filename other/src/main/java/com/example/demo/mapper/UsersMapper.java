package com.example.demo.mapper;

import com.example.demo.entity.Users;
import com.example.demo.utils.MyMapper;

public interface UsersMapper extends MyMapper<Users> {

  Users findCustomOne(String id);
}