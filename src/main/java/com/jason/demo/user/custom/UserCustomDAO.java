package com.jason.demo.user.custom;

import com.jason.demo.user.User;

import java.util.List;

/**
 * @author : kohyusik
 * @version : 1.0
 * @date : 2018-10-21
 * @description :
 */

public interface UserCustomDAO {
    
    List<User> findCustom();
}