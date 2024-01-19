package org.example.my_jira_boot.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.log4j.Log4j2;
import org.example.my_jira_boot.PO.User;
import org.example.my_jira_boot.mapper.UserMapper;
import org.example.my_jira_boot.util.JWTUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Log4j2
@Service
public class LoginService {
    @Resource
    private UserMapper userMapper;

    public String login(User user){
        //校验用户名密码
        if(!checkUser(user)){
            return "用户名或密码错误";
        }
        //生成token
        String token = null;
        try {
            token=JWTUtil.getTokenByRSA256(user);
        } catch (Exception e) {
            log.error("token生成失败"+e);
            return "token生成失败";
        }
        return token;
    }


    //校验用户名密码
    public Boolean checkUser(User user){
        User checkUser = userMapper.selectOne(
                new QueryWrapper<User>()
                        .eq("account", user.getAccount())
        );
        if(checkUser==null){
            return false;
        }
        if(!checkUser.getPassword().equals(user.getPassword())){
            return false;
        }
        return true;
    }
}
