package org.example.my_jira_boot.util;

import org.example.my_jira_boot.general.RSA256Key;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

//RSA256加密工具类
public class RSA256Util {

    public static final String KEY_ALGORITHM = "RSA";

    public static final  int KET_SIZE = 1024;

    private static volatile RSA256Key rsa256Key;

    //单例模式
    //双重校验
    //加锁
    public  static RSA256Key getRSA256Key() throws Exception {
        if (rsa256Key == null) {
            synchronized (RSA256Key.class) {
                if (rsa256Key == null) {
                    KeyPairGenerator keyPairgen = KeyPairGenerator.getInstance(KEY_ALGORITHM);
                    keyPairgen.initialize(KET_SIZE);
                    //通过KeyPairGenerator产生密钥对
                    KeyPair keyPair = keyPairgen.generateKeyPair();
                    //获取公钥
                    RSAPublicKey rsaPublicKey = (RSAPublicKey) keyPair.getPublic();
                    //获取私钥
                    RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) keyPair.getPrivate();
                    rsa256Key = new RSA256Key();
                    rsa256Key.setPublicKey(rsaPublicKey);
                    rsa256Key.setPrivateKey(rsaPrivateKey);
                }
            }
        }
        return rsa256Key;
    }



}
