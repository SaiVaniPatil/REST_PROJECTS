/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sai.rest.mesengerapp.database;

import com.sai.rest.mesengerapp.model.Message;
import com.sai.rest.mesengerapp.model.Profile;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author saipati
 */
public class DatabaseClass {
    
    private static Map<Long, Message> messages = new HashMap<>();

    public static Map<Long, Message> getMessages() {
        return messages;
    }

    public static Map<String, Profile> getProfiles() {
        return profiles;
    }
       private static Map<String, Profile> profiles = new HashMap<>();
       
        
    
    
}
