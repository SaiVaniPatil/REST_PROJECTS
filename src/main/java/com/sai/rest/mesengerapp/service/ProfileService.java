/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sai.rest.mesengerapp.service;

import com.sai.rest.mesengerapp.database.DatabaseClass;
import com.sai.rest.mesengerapp.model.Profile;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author saipati
 */
public class ProfileService {
    
    
    public ProfileService() {

        profiles.put("HW", new Profile("HW", "Hello World", "Sai"));
        profiles.put("HJ", new Profile("HJ", "Hello Jersey", "Sai"));
        profiles.put("HR", new Profile("HR", "Hello Rest", "Sai"));
    }

    private static Map<String, Profile> profiles = DatabaseClass.getProfiles();

    public List<Profile> getAllProfiles() {
        return new ArrayList<Profile>(profiles.values());
    }

    public Profile getProfile(String profileName) {
        return profiles.get(profileName);

    }

    public Profile addProfile(Profile profile) {
        profile.setId((profiles.size()+ 1));

        profiles.put(profile.getProfileName(), profile);
        return profile;
    }

    public Profile updateProfile(Profile profile) {

        if (profile.getProfileName().length()<= 0) {
            return null;
        }

        profiles.put(profile.getProfileName(), profile);
        return profile;
    }

    public Profile removeProfile(String profileName) {
        return profiles.remove(profileName);
    }
    
}
