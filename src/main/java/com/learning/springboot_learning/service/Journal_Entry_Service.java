package com.learning.springboot_learning.service;

import com.learning.springboot_learning.entity.Journal_Entry;
import com.learning.springboot_learning.repository.Journal_Entry_repository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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

    public Optional<Journal_Entry> get_by_id(ObjectId id){
        return journalEntryRepository.findById(id);
    }

    public Optional<Journal_Entry> delete_by_id(ObjectId id ){
        Optional<Journal_Entry> objectId = journalEntryRepository.findById(id);
        if(journalEntryRepository.existsById(id)) {
            journalEntryRepository.deleteById(id);
        }
        return objectId;
    }

    public Optional<Journal_Entry> update_by_id(ObjectId id , Journal_Entry journalEntry){

        Optional<Journal_Entry> journalEntryOptional = journalEntryRepository.findById(id);

        if(journalEntryOptional.isPresent()){
            journalEntry.setId(id);
            journalEntryRepository.save(journalEntry);
        }
        return journalEntryOptional;

    }

}


// controller --> service --> repository