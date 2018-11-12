package com.jason.demo.member;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author : kohyusik
 * @version : 1.0
 * @date : 2018-11-12
 * @description :
 */

@Data
@Entity
@Table(name = "ROLE")
public class Roles {
    
    @Id
    @Column(name = "ROLE_UID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "ROLE_NAME")
    private Role roleName;
    
    @Override
    public boolean equals(Object o) {
        
        if (this == o)
            return true;
        if (!(o instanceof Roles))
            return false;
        Roles that = (Roles) o;
        return Objects.equals(getRoleName(), that.getRoleName());
    }
    
    @Override
    public int hashCode() {
        
        return Objects.hash(getRoleName());
    }
}
