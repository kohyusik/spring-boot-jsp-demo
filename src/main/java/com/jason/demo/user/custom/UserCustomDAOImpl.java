package com.jason.demo.user.custom;

import com.jason.demo.user.User;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * @author : kohyusik
 * @version : 1.0
 * @date : 2018-10-21
 * @description :
 */

public class UserCustomDAOImpl implements UserCustomDAO {
    
    protected EntityManager entityManager;
    
    public UserCustomDAOImpl(EntityManager entityManager) {
        
        this.entityManager = entityManager;
    }
    
    @Override
    public List<User> findCustom() {
        
//        QUser user = QUser.user;
//        JPAQuery query = new JPAQuery(entityManager);
//
//        query.from(user)
//                .where(user.name.between(1, 2)
//                );
//
//
//        List<User> users = query.fetch();
//
//        System.out.println(query);
//        System.out.println(query.fetchCount());
//        System.out.println(users);
//
//        return users;
        return null;
        
    }
}