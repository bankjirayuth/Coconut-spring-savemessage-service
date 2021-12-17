package com.example.springsavemessageservice.repository;

import com.example.springsavemessageservice.pojo.Inventory;
import com.example.springsavemessageservice.pojo.Message;
import com.example.springsavemessageservice.pojo.RabbitInventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SaveMessageService {
    @Autowired
    SaveMessageRepository saveMessageRepository;

    public boolean findName(String name){
        System.out.println("SaveMessageService : "+ name);
        Inventory inventory = saveMessageRepository.findUsersByName(name);

        if (inventory != null){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean createInventory(RabbitInventory rabbitInventory){

        Inventory inventory = new Inventory();

        inventory.setName(rabbitInventory.getName());
        inventory.setItems(new ArrayList<Message>());
        inventory.getItems().add(rabbitInventory.getMessage());

        saveMessageRepository.save(inventory);
        return true;
    }

    public boolean updateInventory(RabbitInventory rabbitInventory){

        Inventory inventory = saveMessageRepository.findUsersByName(rabbitInventory.getName());

        inventory.getItems().add(rabbitInventory.getMessage());

        saveMessageRepository.save(inventory);
        return true;
    }

    public Inventory getInventory(String name){
        Inventory inventory = saveMessageRepository.findUsersByName(name);

        return inventory;
    }

}
