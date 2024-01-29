package com.tweterooapi.api.repositories;

import com.tweterooapi.api.models.TweetsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TweetsRepository extends JpaRepository<TweetsModel, Long>{
    
}
