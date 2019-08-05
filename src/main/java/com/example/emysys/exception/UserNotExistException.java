package com.example.emysys.exception;
/**
 * ClassName: UserNotExistException.java
 * Author: chenyiAlone
 * Create Time: 2019/8/5 22:17
 * Description: 自定义异常 - 用户不存在异常
 */
public class UserNotExistException extends RuntimeException {

    public UserNotExistException() {
        super("用户不存在");
    }
}
