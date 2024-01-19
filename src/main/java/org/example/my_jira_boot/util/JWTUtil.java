package org.example.my_jira_boot.util;

import com.alibaba.fastjson2.JSON;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import lombok.extern.log4j.Log4j2;
import org.example.my_jira_boot.general.RSA256Key;

import java.util.Date;


//JWT工具类
@Log4j2
public class JWTUtil {

    //获取token
    public static String getTokenByRSA256(Object data) throws Exception {
        //公钥
        RSA256Key rsa256Key = RSA256Util.getRSA256Key();

        Algorithm algorithm = Algorithm.RSA256(rsa256Key.getPublicKey(), rsa256Key.getPrivateKey());

        String token = JWT.create()
                //信息
                .withClaim("data", JSON.toJSONString(data))
                //签发时间
                .withIssuedAt(new Date())
                //过期时间
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 7))
                .sign(algorithm);
        return token;
    }

    //验证token
    public static Boolean verifyTokenByRSA256(String token) throws Exception {
        //公钥
        RSA256Key rsa256Key = RSA256Util.getRSA256Key();

        Algorithm algorithm = Algorithm.RSA256(rsa256Key.getPublicKey(), rsa256Key.getPrivateKey());

        try {
            JWT.require(algorithm).build().verify(token);
            return true;
        } catch (JWTVerificationException e) {
            log.error("token验证失败");
            return false;
        }
    }


}
