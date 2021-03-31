package me.moon.boardTemplate.utils;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class Message {

    private String msg;

    public Message(String msg) {
        this.msg = msg;
    }

    public Map<String,String> Message(String msg){
        Map<String, String> message = new HashMap<>();
        message.put("msg", this.msg);
        return message;
    }
}
