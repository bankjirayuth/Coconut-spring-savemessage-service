package com.example.springsavemessageservice.repository;

import com.example.springsavemessageservice.pojo.Inventory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SaveMessageRepository extends MongoRepository<Inventory,String> {
    @Query(value = "{ name: '?0' }")
    public Inventory findUsersByName(String name);
}
