package com.example.demo.controller;

import com.example.demo.domain.bo.LoginLog;
import com.example.demo.domain.bo.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 用户名校验
     *
     * @param name
     * @return
     */
    @GetMapping(value = "/checkUserName")
    public User checkUserName(@RequestParam(value = "name") String name) {
        return userService.checkUserName(name);
    }

    /**
     * 注册
     *
     * @param user
     * @return
     */

    @PostMapping(value = "/register")
    public User register(@RequestBody User user) {
        return userService.register(user);
    }


    /**
     * 登录
     *
     * @param user
     * @return
     */
    @PostMapping(value = "/login")
    public User login(@RequestBody User user) throws Exception {
        return userService.login(user.getUserName(),user.getPassword());
    }

    /**
     * 标记下次修改密码
     * @param user
     * @return
     */
    public User signNextChangePassword(@RequestBody User user) {
        return userService.signNextChangePassword(user.getId());
    }

    /**
     * 删除用户（逻辑删除，更新账号状态）
     *
     * @param user
     * @return
     */
    @PostMapping(value = "/deleteUser")
    public User deleteUser(@RequestBody User user) {
        return userService.deleteUser(user.getId());
    }

    /**
     * 批量删除用户
     *
     * @param users
     * @return
     */
    @PostMapping(value = "/batchDeleteUser")
    public List<User> batchDeleteUser(@RequestBody List<User> users) {
        ArrayList<Integer> userIds = new ArrayList<>();
        users.parallelStream().forEach(user -> {
            userIds.add(user.getId());
        });
        return userService.batchDeleteUser(userIds);
    }

    /**
     * 配置密码策略
     * @param userId
     * @param strategyId
     * @return
     */
    @PostMapping(value = "/configureStrategy")
    public User configureStrategy(@RequestParam(value = "userId") Integer userId,
                                  @RequestParam(value = "strategyId")Integer strategyId) {
        return userService.configureStrategy(userId,strategyId);
    }

    /**
     * 批量配置密码策略
     *
     * @param map
     * @return
     */
    @PostMapping(value = "/batchConfigureStrategy")
    public List<User> batchConfigureStrategy(@RequestBody Map<Integer,Integer> map) {
        return userService.batchConfigureStrategy(map);
    }


    /**
     * 查询登录日志
     *
     * @param user
     * @return
     */
    @PostMapping(value = "/findLoginLogByUserId")
    public List<LoginLog> findLoginLogByUserId(@RequestBody User user) {
        return userService.findLoginLogByUserId(user.getId());
    }


    /**
     * 用户分页
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping(value = "/pageUser")
    public Page<User> pageUser(@RequestParam(value = "pageNum") Integer pageNum,
                               @RequestParam(value = "pageSize") Integer pageSize) {
        return userService.pageUser(pageNum, pageSize);
    }
}
