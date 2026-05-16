package com.learning.springboot_learning.controller;

import com.learning.springboot_learning.entity.Journal_Entry;
import com.learning.springboot_learning.service.Journal_Entry_Service;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController // Component with http requests
@RequestMapping("/journal")     // mapping in the entire class
public class Journal_Entry_Controller_v2 {


    @Autowired
    Journal_Entry_Service journalEntryService;

    @GetMapping(/*"/abc"*/)

    public List<Journal_Entry> getAll() {
        return journalEntryService.getAll();
    }


    @PostMapping

    // for localhost:8080/journal , for post this method
    public ResponseEntity<Journal_Entry> createEntry(@RequestBody Journal_Entry myEntry) {
        try {
            journalEntryService.save_Journal_Entry(myEntry);
            return new ResponseEntity<>(myEntry,HttpStatus.CREATED);
        }
        catch (Exception e ){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }


    }

    @GetMapping("/id/{myid}")
    public ResponseEntity<Journal_Entry> get_byId(@PathVariable ObjectId myid){

        Optional<Journal_Entry> journalEntryOptional = journalEntryService.get_by_id(myid);
        return journalEntryOptional.map(journalEntry ->
                new ResponseEntity<>(journalEntry, HttpStatus.OK)).orElseGet(() ->
                new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @DeleteMapping("/id/{myid}")
    public ResponseEntity<?> delete_byId(@PathVariable ObjectId myid){
        Optional<Journal_Entry> journalEntry = journalEntryService.delete_by_id(myid);
        if(journalEntry.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }


    @PutMapping("/id/{id}")
    public ResponseEntity<String> update(@PathVariable ObjectId id , @RequestBody Journal_Entry entry){

        Optional<Journal_Entry> journalEntry = journalEntryService.update_by_id(id,entry);

        if(journalEntry.isPresent()){
            return new ResponseEntity<>("Update successful ",HttpStatus.OK);
        }
        return new ResponseEntity<>("Id not present ", HttpStatus.NOT_FOUND);

    }

}

