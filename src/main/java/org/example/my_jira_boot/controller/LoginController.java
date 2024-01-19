package org.example.my_jira_boot.controller;

import org.example.my_jira_boot.PO.User;
import org.example.my_jira_boot.service.LoginService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class LoginController {

    @Resource
    private LoginService loginService;

    @PostMapping(path = "/login")
    public void login(@RequestBody User user) {
        loginService.login(user);
        System.out.println("login");
    }
}
