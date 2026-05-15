package com.learning.springboot_learning.entity;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Date;

@Document(collection = "journal_entries")  // informs spring that this class is a mongodb mapped document
public class Journal_Entry {
    public String getId() {
        return id.toHexString();
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }



    private ObjectId id;

    private String title;

    private String content;

    private LocalDateTime date;

    public void setDate(LocalDateTime now) {
        this.date=now;

    }

}
