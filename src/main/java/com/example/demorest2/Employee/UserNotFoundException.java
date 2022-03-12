package com.example.demorest2.Employee;


import org.springframework.http.HttpStatus;
        import org.springframework.web.bind.annotation.ResponseStatus;


//Q-6
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String s) {
        super(s);
    }
}