package com.example.authbackend.model;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name="email", nullable = false, length = 50, unique = true)
    @NotEmpty
    private String email;

    @Column(name="username", nullable = false, length = 50, unique = true)
    @NotEmpty
    private String username;

    @Column(name="password", nullable = false)
    @NotEmpty
    private String password;

    public User(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }


}
