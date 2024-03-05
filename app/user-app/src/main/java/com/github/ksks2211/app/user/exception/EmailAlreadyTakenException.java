package com.github.ksks2211.app.user.entity;

import javax.naming.AuthenticationException;

/**
 * @author rival
 * @since 2024-02-28
 */
public class EmailAlreadyTakenException extends AuthenticationException {

    public EmailAlreadyTakenException(String msg){
        super(msg);
    }
}
