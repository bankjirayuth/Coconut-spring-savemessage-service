package com.example.springsavemessageservice.controller;

import com.example.springsavemessageservice.data.ObjInput;
import com.example.springsavemessageservice.pojo.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class SaveMsgConsumer {
    protected User user;

    public SaveMsgConsumer() {
        this.user = new User();
    }

    @RabbitListener(queues = "SaveMsgQueue")
//    public void addToSaveMsgQueue(User user){
    public void addToSaveMsgQueue(ObjInput input){
        System.out.println(input.getName());
//    public void addToSaveMsgQueue(String input){
//        System.out.println(input);
    }
}
