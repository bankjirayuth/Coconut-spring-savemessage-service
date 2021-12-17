package com.example.springsavemessageservice.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;

@Data
@Document(value = "Inventory")
public class Inventory {
    @Id
    private String _id;
    private String name;
    private ArrayList<Message> items;
}
