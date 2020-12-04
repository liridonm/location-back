package com.test.location.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * User model/table with all property we need.
 */
@Table(name = "users")
@Entity
@Getter
@Setter
public class User extends Model<Integer>{

    @Email
    @NotNull
    @Column(unique = true)
    private String email;

    @NotNull
    @Size(min = 6, message = "Password should not be less than 6")
    private String password;

    @NotNull
    @Column(unique = true)
    private String username;
}
