package com.example.springsavemessageservice.consumers;

import com.example.springsavemessageservice.MQConfig;
import com.example.springsavemessageservice.pojo.Message;
import com.example.springsavemessageservice.pojo.RabbitInventory;
import com.example.springsavemessageservice.repository.SaveMessageService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class SaveMessageConsumers {

    @Autowired
    SaveMessageService saveMessageService;

    @RabbitListener(queues = MQConfig.QUEUE)
    public void saveInventory(RabbitInventory rabbitInventory) {
        System.out.println(rabbitInventory.getName());
        if (saveMessageService.findName(rabbitInventory.getName())){
            System.out.println("you have");
            saveMessageService.updateInventory(rabbitInventory);
        }else {
            System.out.println("No!!!");
            saveMessageService.createInventory(rabbitInventory);
        }
    }

}
