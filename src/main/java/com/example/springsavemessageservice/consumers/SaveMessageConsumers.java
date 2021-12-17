package com.example.springsavemessageservice.consumers;

import com.example.springsavemessageservice.MQConfig;
import com.example.springsavemessageservice.pojo.Message;
import com.example.springsavemessageservice.pojo.RabbitInventory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class SaveMessageConsumers {

    @RabbitListener(queues = MQConfig.QUEUE)
    public void saveInventory(RabbitInventory rabbitInventory) {
        System.out.println(rabbitInventory);
    }

}
