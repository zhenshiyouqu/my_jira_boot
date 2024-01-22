package org.example.my_jira_boot.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.log4j.Log4j2;
import org.example.my_jira_boot.PO.User;
import org.example.my_jira_boot.exception.GeneralException;
import org.example.my_jira_boot.exception.MsgEnum;
import org.example.my_jira_boot.mapper.UserMapper;
import org.example.my_jira_boot.util.JWTUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Log4j2
@Service
public class LoginService {
    @Resource
    private UserMapper userMapper;

    //注册
    public String register(User user){
        //校验用户名是否存在
        User checkUser = userMapper.selectOne(
                new QueryWrapper<User>()
                        .eq("account", user.getAccount())
        );
        if(checkUser!=null){
            throw new GeneralException(MsgEnum.USER_EXIST_ERROR);
        }
        //插入用户
        int insert = userMapper.insert(user);
        if(insert!=1){
            throw new GeneralException(MsgEnum.USER_INSERT_ERROR);
        }
        return "注册成功";
    }


    //登录
    public String login(User user){
        //校验用户名密码
        if(!checkUser(user)){
            throw new GeneralException(MsgEnum.USER_PASSWORD_ERROR);
        }
        //生成token
        String token = null;
        try {
            token=JWTUtil.getTokenByRSA256(user);
        } catch (Exception e) {
            throw new GeneralException(MsgEnum.TOKEN_GET_ERROR);
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
