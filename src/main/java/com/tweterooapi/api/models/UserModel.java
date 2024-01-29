package com.tweterooapi.api.models;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

import com.tweterooapi.api.dtos.UserDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class UserModel {

    public UserModel(UserDTO dto) {
        this.username = dto.getUsername();
        this.avatar = dto.getAvatar();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(unique = true, nullable = false, length = 100)
    private String username;

    @Column(unique = false, nullable = false)
    private String avatar;


}
