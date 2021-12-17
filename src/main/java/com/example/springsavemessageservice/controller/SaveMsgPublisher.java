package com.example.springsavemessageservice.controller;

import com.example.springsavemessageservice.data.ObjInput;
import com.example.springsavemessageservice.pojo.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaveMsgPublisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping(value = "/saveMsg", method = RequestMethod.POST)
    public boolean saveMessage(@RequestBody ObjInput input){
//        String x = input.getName() +" " +input.getMessage();
        try {
            rabbitTemplate.convertAndSend("DirectSaveMsg","save",input);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
