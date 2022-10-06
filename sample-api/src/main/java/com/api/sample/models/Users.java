package com.api.sample.models;


import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
@NoArgsConstructor
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "user_id")
    private String userId;

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String userPassword;

    @Column(name = "scope")
    private String scope;

    @Column(name = "is_active")
    private boolean isActives;
}
