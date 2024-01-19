package org.example.my_jira_boot.controller;

import org.example.my_jira_boot.PO.User;
import org.example.my_jira_boot.general.Result;
import org.example.my_jira_boot.general.ResultUtil;
import org.example.my_jira_boot.service.LoginService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class LoginController {

    @Resource
    private LoginService loginService;

    //登录
    @PostMapping(path = "/login")
    public Result<String> login(@RequestBody User user) {
        String login = loginService.login(user);
        return ResultUtil.success(login);
    }


}
