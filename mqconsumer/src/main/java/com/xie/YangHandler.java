package com.xie;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

public class YangHandler implements MessageListener {

    private static final ObjectMapper mapper = new ObjectMapper();

    @Override
    public void onMessage(Message message) {
        try {
            JsonNode jsonNode = mapper.readTree(message.getBody());
            String name = jsonNode.get("name").asText();
            Integer age = jsonNode.get("age").asInt();
            System.out.println("YangHandler result : "+name +", "+age);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
