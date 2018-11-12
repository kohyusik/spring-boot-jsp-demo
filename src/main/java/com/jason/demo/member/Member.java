package com.jason.demo.member;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * @author : kohyusik
 * @version : 1.0
 * @date : 2018-10-21
 * @description :
 */

@Data
@Entity
@Table(name="MEMBER")
public class Member {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;
    
    @Column(nullable = false, unique = true, length=50)
    private String name;
    
    @Column(nullable = false, length=200)
    private String password;
    
    @Column(nullable = false, unique = true, length=50)
    private String email;
    
    @CreationTimestamp
    private Date regdate;
    
    @UpdateTimestamp
    private Date updatedate;
    
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinColumn(name="user_uid", referencedColumnName = "uid")
    private Set<Roles> roles;

}