package com.travel_planner.travel_planner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travel_planner.travel_planner.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

    public boolean existsByUserId(String userId);
    public boolean existsByUserEmail(String userEmail);
    public boolean existsByTelNumber(String telNumber);
    public boolean existsByUserName(String userName);

    public boolean existsByUserEmailOrUserIdOrTelNumberOrUserName(String userEmail, String userId, String telNumber, String userName);

    public UserEntity findByUserId(String userId);
    
}
