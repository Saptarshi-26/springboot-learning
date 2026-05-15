package com.learning.springboot_learning.controller;

import com.learning.springboot_learning.entity.Journal_Entry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController // Component with http requests
@RequestMapping("/_journal")     // mapping in the entire class
public class Journal_Entry_Controller {

    private Map<Long, Journal_Entry> journalEntryMap = new HashMap<>();

    @GetMapping(/*"/abc"*/)   // new end point will be journal/abc

    // for localhost:8080/journal , for get this method
    public List<Journal_Entry> getAll() {
        return new ArrayList<>(journalEntryMap.values());
    }


    @PostMapping

    // for localhost:8080/journal , for post this method
    public boolean createEntry(@RequestBody Journal_Entry myEntry) { // to tell spring to take data from
                                                                         // request and turn into a java object
       // journalEntryMap.put(myEntry.getId(),myEntry);
        return true;

    }

    @GetMapping("/id/{myid}")
    public Journal_Entry get_byId(@PathVariable long myid){
        return journalEntryMap.get(myid);
    }

    @DeleteMapping("/id/{myid}")
    public String delete_byId(@PathVariable long myid){
        if(journalEntryMap.containsKey(myid)) {
            journalEntryMap.remove(myid);
            return "Successful deletion ";
        }
        return "id not found ";
    }


    @PutMapping("/id/{id}")
    public Journal_Entry update(@PathVariable long id , @RequestBody Journal_Entry entry){
        journalEntryMap.put(id,entry);
        return journalEntryMap.get(id);
    }

}

