/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sai.rest.mesengerapp;

import com.sai.rest.mesengerapp.model.Profile;
import com.sai.rest.mesengerapp.service.ProfileService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author saipati
 */
@Path("profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {
    
       ProfileService profileService = new ProfileService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Profile> getProfiles() {
        return profileService.getAllProfiles();
    }

    @GET
    @Path("/{profileId}")

    public Profile getProfile(@PathParam("profileId") String profileName) {
        return profileService.getProfile(profileName);

    }

    @POST

    public Profile addProfile(Profile profile) {
        return profileService.addProfile(profile);

    }

    @PUT
    @Path("/{profileName}")
    public Profile updateProfile(@PathParam("profileId") String profileName, Profile msg) {
        msg.setProfileName(profileName);
        return profileService.updateProfile(msg);

    }

    @DELETE
    @Path("/{profileName}")
    public void updateProfile(@PathParam("profileName") String profileName) {

        profileService.removeProfile(profileName);

    }
    
}
