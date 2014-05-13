package com.secureapp.rap.service;

import com.secureapp.rap.domain.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA 13.
 * by Anfield.
 */
@Service
public class UserManager {
    private HashMap<String, User> users;

    public UserManager() {
        users = new HashMap<String, User>();
        users.put("john", new User("john", "1", "ROLE_USER"));
        users.put("bob", new User("bob", "2", "ROLE_USER, ROLE_ADMIN"));
    }

    public User getUser(String username) throws UsernameNotFoundException {
        if( !users.containsKey( username ) ){
            throw new UsernameNotFoundException( username + " not found" );
        }

        return users.get( username );
    }
}