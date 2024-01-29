package com.tweterooapi.api.repositories;

import com.tweterooapi.api.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long>{

    
}