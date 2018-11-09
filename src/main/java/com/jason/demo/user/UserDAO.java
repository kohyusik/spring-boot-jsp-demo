package com.jason.demo.user;

import com.jason.demo.user.custom.UserCustomDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : kohyusik
 * @version : 1.0
 * @date : 2018-10-21
 * @description :
 */

@Repository
public interface UserDAO extends JpaRepository<User, Long>, UserCustomDAO {
    
}