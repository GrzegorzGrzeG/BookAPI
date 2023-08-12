package org.example.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NotFoundException extends RuntimeException{
    public NotFoundException(String msg) {
        super(msg);
        log.info(msg);
    }
}
