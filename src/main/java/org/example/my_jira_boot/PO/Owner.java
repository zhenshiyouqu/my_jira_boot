package org.example.my_jira_boot.PO;

import lombok.Data;

@Data
public class Owner {
    private Integer id;
    private String name;
    private String password;
    private String email;
    private String phone;
    private String avatar;
    private String role;
    private String status;
    private String create_time;
    private String update_time;
}
