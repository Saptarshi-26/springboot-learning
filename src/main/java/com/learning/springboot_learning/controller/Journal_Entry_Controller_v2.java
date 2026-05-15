package com.learning.springboot_learning.controller;

import com.learning.springboot_learning.entity.Journal_Entry;
import com.learning.springboot_learning.service.Journal_Entry_Service;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public boolean createEntry(@RequestBody Journal_Entry myEntry) {
        journalEntryService.save_Journal_Entry(myEntry);
        return true;

    }

    @GetMapping("/id/{myid}")
    public Journal_Entry get_byId(@PathVariable ObjectId myid){
           return journalEntryService.get_by_id(myid);
    }

    @DeleteMapping("/id/{myid}")
    public String delete_byId(@PathVariable ObjectId myid){
        return journalEntryService.delete_by_id(myid);

    }


    @PutMapping("/id/{id}")
    public String update(@PathVariable ObjectId id , @RequestBody Journal_Entry entry){
          return journalEntryService.update_by_id(id, entry);
    }

}

