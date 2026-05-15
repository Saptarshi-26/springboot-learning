package com.learning.springboot_learning.repository;
import com.learning.springboot_learning.entity.Journal_Entry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Journal_Entry_repository extends MongoRepository<Journal_Entry, ObjectId>{

}