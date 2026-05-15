package com.learning.springboot_learning.service;

import com.learning.springboot_learning.entity.Journal_Entry;
import com.learning.springboot_learning.repository.Journal_Entry_repository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class Journal_Entry_Service {
    @Autowired
   private Journal_Entry_repository journalEntryRepository;   // here the implementation of this
                                                              // interface is given by the spring

    public  void save_Journal_Entry(Journal_Entry journalEntry){
        journalEntry.setDate(LocalDateTime.now());
        journalEntryRepository.save(journalEntry);
    }

    public List<Journal_Entry> getAll(){
        return journalEntryRepository.findAll();
    }

    public Journal_Entry get_by_id(ObjectId id){
        return journalEntryRepository.findById(id).orElse(null);
    }

    public String delete_by_id(ObjectId id ){
        if(journalEntryRepository.existsById(id)) {
            journalEntryRepository.deleteById(id);
            return "deletion success";
        }
        return "id does not exists";
    }

    public String update_by_id(ObjectId id , Journal_Entry journalEntry){
        if(journalEntryRepository.existsById(id)) {
            journalEntry.setId(id);
            journalEntryRepository.save(journalEntry);
            return "update successful";
        }
        return "id not found";

    }

}


// controller --> service --> repository