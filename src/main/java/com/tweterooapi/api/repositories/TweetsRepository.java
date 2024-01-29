package com.tweterooapi.api.repositories;

import com.tweterooapi.api.models.TweetsModel;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
    public interface TweetsRepository extends JpaRepository<TweetsModel, Long> {
        @Query(value = "SELECT * FROM tweets WHERE user_id = :userId", nativeQuery = true)
        List<TweetsModel> findTweetsByUserid(@Param("userId") Long userId);
    
}
