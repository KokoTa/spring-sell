package com.example.demo.service.impl;

import java.util.List;

import com.example.demo.entity.Users;
import com.example.demo.mapper.UsersMapper;
import com.example.demo.service.UserService;
import com.github.pagehelper.PageHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import tk.mybatis.mapper.entity.Example;

/**
 * UserServiceImpl
 */
@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UsersMapper usersMapper;

  @Override
  @Transactional(propagation = Propagation.REQUIRED) // ! 增删改用 REQUIRED，查询用 SUPPORTS，其实不指定也没事，因为 Spring 默认会以方法名开头(get/set。。。)等来判断使用什么模式
  public void saveUser(final Users user) {
    usersMapper.insert(user);
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED)
  public void updateUser(final Users user) {
    usersMapper.updateByPrimaryKeySelective(user);
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED)
  public void deleteUser(final Users user) {
    // TODO Auto-generated method stub

  }

  @Override
  @Transactional(propagation = Propagation.SUPPORTS)
  public Users findUserById(final String id) {
    final Users user = usersMapper.selectByPrimaryKey(id);
    return user;
  }

  @Override
  @Transactional(propagation = Propagation.SUPPORTS)
  public List<Users> findUserList(final Users user, final Integer page, final Integer pageSize) {
    // 开始分页
    PageHelper.startPage(page, pageSize);

    final Example example = new Example(Users.class);

    // 推荐直接用 sql 写这种过滤条件
    // Example.Criteria criteria = example.createCriteria();
    // if (!StringUtils.isEmptyOrWhitespaceOnly(user.getNickname())) {
    // criteria.andLike("nickname", "%" + user.getNickname() + "%");
    // }

    final List<Users> list = usersMapper.selectByExample(example);

    return list;
  }

  @Override
  @Transactional(propagation = Propagation.SUPPORTS)
  public Users findCustomeOne(String id) {

    Users user = usersMapper.findCustomOne(id);

    return user;
  }

}