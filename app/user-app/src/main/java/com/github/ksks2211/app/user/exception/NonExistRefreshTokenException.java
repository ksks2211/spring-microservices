package com.github.ksks2211.app.user.exception;

import jakarta.persistence.EntityNotFoundException;

/**
 * @author rival
 * @since 2024-02-28
 */
public class RefreshTokenNotFoundException extends EntityNotFoundException {

    public RefreshTokenNotFoundException(String msg){
        super(msg);
    }

}
