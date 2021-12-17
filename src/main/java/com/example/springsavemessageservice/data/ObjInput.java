package com.example.springsavemessageservice.data;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;

@Data
public class ObjInput implements Serializable {
    private String name;
    private ArrayList<Object> message;
}
