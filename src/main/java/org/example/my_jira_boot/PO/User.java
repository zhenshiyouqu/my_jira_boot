package org.example.my_jira_boot.PO;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

//  `id` int NOT NULL AUTO_INCREMENT COMMENT '用户id',
//  `name` varchar(255) DEFAULT NULL COMMENT '用户姓名',
//  `account` varchar(255) DEFAULT NULL COMMENT '用户账号',
//  `password` varchar(255) DEFAULT NULL COMMENT '用户密码',
//  `email` varchar(255) DEFAULT NULL COMMENT '用户邮箱',
//  `phone` varchar(255) DEFAULT NULL COMMENT '用户电话',
//  `avatar` varchar(255) DEFAULT NULL COMMENT '用户头像',
//  `role` varchar(255) DEFAULT NULL COMMENT '用户角色:admin-管理员,developer-开发者,tester-测试人员,product-产品经理',
//  `status` varchar(255) DEFAULT NULL COMMENT '用户状态:0-禁用,1-启用',
//  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
//  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',

@Data
@TableName("user")
public class User {
    @TableId
    private Integer id;
    private String name;
    private String account;
    private String password;
    private String email;
    private String phone;
    private String avatar;
    private String role;
    private String status;
    private String createTime;
    private String updateTime;
}
