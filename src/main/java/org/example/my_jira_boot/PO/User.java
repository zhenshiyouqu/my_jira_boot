package org.example.my_jira_boot.PO;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user")
public class User {
    @TableId
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
