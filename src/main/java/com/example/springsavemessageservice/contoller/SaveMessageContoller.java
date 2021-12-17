package com.example.springsavemessageservice.contoller;


import com.example.springsavemessageservice.pojo.Inventory;
import com.example.springsavemessageservice.repository.SaveMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "inventory")
public class SaveMessageContoller {

    @Autowired
    SaveMessageService saveMessageService;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Inventory getInventory(@RequestHeader(value = "name") String name){
        return saveMessageService.getInventory(name);
    }
}
