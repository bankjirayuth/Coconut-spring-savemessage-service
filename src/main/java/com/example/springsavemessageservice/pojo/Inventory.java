package com.example.springsavemessageservice.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.ArrayList;

@Data
public class Inventory {
    @Id
    private String _id;
    private String name;
    private ArrayList<Message> inventory;
}
