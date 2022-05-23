/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sai.rest.mesengerapp.service;

import com.sai.rest.mesengerapp.database.DatabaseClass;
import com.sai.rest.mesengerapp.model.Message;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 *
 * @author saipati
 */
public class MessageService {

    public MessageService() {

        messages.put(1L, new Message(1L, "Hello World", "Sai"));
        messages.put(2L, new Message(2L, "Hello Jersey", "Sai"));
        messages.put(3L, new Message(3L, "Hello Rest", "Sai"));
    }

    private static Map<Long, Message> messages = DatabaseClass.getMessages();

    public List<Message> getAllMessages() {
        return new ArrayList<Message>(messages.values());
    }
    
     public List<Message> getAllMessagesInaYear(int year) {
         
         List<Message> msgsInYear = new ArrayList<>();
         Calendar cal = Calendar.getInstance();
         
         for(Message msg:messages.values())
         {
             cal.setTime(msg.getCreated());
             if(cal.get(Calendar.YEAR)==year)
             {
                 msgsInYear.add(msg);
             }
             
         }
        return msgsInYear;
    }
     
      public List<Message> getRangeOfMessages(int start,int size) {
          
            ArrayList<Message> msgList = new ArrayList<>(messages.values());
            
            if((start+size)>msgList.size() )return new ArrayList<>();
        return msgList.subList(start, start+size);
    }


    public Message getMessage(Long id) {
        return messages.get(id);

    }

    public Message addMessage(Message message) {
        message.setId(messages.size() + 1);

        messages.put(message.getId(), message);
        return message;
    }

    public Message updateMessage(Message message) {

        if (message.getId() <= 0) {
            return null;
        }

        messages.put(message.getId(), message);
        return message;
    }

    public Message removeMessage(long id) {
        return messages.remove(id);
    }
}
