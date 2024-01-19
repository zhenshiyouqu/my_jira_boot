package org.example.my_jira_boot.service;

import org.example.my_jira_boot.PO.User;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    public void login(User user) {
        System.out.println("login");
    }
}
