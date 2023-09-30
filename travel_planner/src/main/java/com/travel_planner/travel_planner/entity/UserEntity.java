package com.travel_planner.travel_planner.entity;

import com.travel_planner.travel_planner.dto.request.auth.PostSignUpDto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="User")
@Table(name="User")
public class UserEntity {
    @Id
    private String userId;
    private String userName;
    private String password;
    private String userEmail;
    private String telNumber;

        public UserEntity(PostSignUpDto dto) {
        this.userId = dto.getUserId();
        this.userName = dto.getUserName();
        this.password = dto.getPassword();
        this.userEmail = dto.getUserEmail();
        this.telNumber = dto.getTelNumber();
    }
}
