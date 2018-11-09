package com.jason.demo.user;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class UserService {

    private UserDAO dao;

    public UserService(UserDAO dao) {

        this.dao = dao;
    }

    public User findById(Long id) {

        return dao.findById(id).get();
    }

    public List<User> findAll() {

        return dao.findAll();
    }
    
    public List<User> findCustom() {
        
        return dao.findCustom();
    }

    @PostConstruct
    public void initMembers() {
        // set members
        String[] memberNames = { "koh", "yu", "sik" };
        for (String username : memberNames) {
            User user = new User();
            user.setUsername(username);
            dao.save(user);
        }

    }
}
