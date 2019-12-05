package com.example.demo.controller;

import java.util.List;
import java.util.concurrent.Future;

import com.example.demo.entity.Users;
import com.example.demo.service.impl.UserServiceImpl;
import com.example.demo.task.TestTask;

import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;

import org.springframework.web.bind.annotation.RequestParam;

@Data
class Page {
    private Integer pageNo;

    private Integer pageSize;
}

/**
 * @author KokoTa
 * @create 2019/12/3
 */
@RestController
public class TestController {

    @Autowired
    UserServiceImpl userServiceImpl;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    TestTask testTask;

    /**
     * 保存用户
     */
    @GetMapping("/saveUser")
    public void saveUser() throws Exception {
        final String userId = Sid.nextShort();
        final Users user = new Users();
        user.setId(userId);
        user.setUsername("KokoTa");
        user.setNickname("Brain");
        user.setPassword("123456");
        user.setFanceCounts(0);
        user.setFollowCounts(0);
        user.setReceiveLikeCounts(0);

        userServiceImpl.saveUser(user);
    }

    /**
     * 返回用户列表
     * @param page
     * @return
     * @throws Exception
     */
    @GetMapping("/userList")
    public List<Users> userList(Page page) throws Exception {
        List<Users> list = userServiceImpl.findUserList(new Users(), page.getPageNo(), page.getPageSize());
        return list;
    }

    /**
     * 更新用户
     * @param id
     * @throws Exception
     */
    @PutMapping("/updateUser")
    public void getMethodName(@RequestParam("id") final String id) throws Exception {

        String username = Sid.nextShort();

        Users user = userServiceImpl.findUserById(id);
        user.setUsername(username);

        userServiceImpl.updateUser(user);
    }

    /**
     * mapper 自定义 sql 查询
     */
    @GetMapping("/findCustomOne")
    public Users findCustomeOne(String id) {
        Users user = userServiceImpl.findCustomeOne(id);

        return user;
    }

    /**
     * redis 测试
     */
    @GetMapping("/redis")
    public String redis() {
        stringRedisTemplate.opsForValue().set("name", "Brain");
        String name = stringRedisTemplate.opsForValue().get("name");
        return name;
    }

    /**
     * 异步任务测试
     * 
     * @throws InterruptedException
     */
    @GetMapping("/async")
    public void async() throws InterruptedException {
        long start = System.currentTimeMillis();

        Future<Boolean> a = testTask.syncMethod1();
        Future<Boolean> b = testTask.syncMethod2();

        while (!a.isDone() || !b.isDone()) {
            if (a.isDone() && b.isDone()) {
                break;
            }
        }

        long end = System.currentTimeMillis();

        System.out.println(end - start);
    }
}
