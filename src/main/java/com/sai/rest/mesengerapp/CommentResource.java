/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sai.rest.mesengerapp;

import com.sai.rest.mesengerapp.model.Message;
import java.util.List;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author saipati
 */
@Path("")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CommentResource {
    
    
    @GET   
    public String  getComments() {
        
       return "new Subresource 2";
    }
    
    
     @GET 
     @Path("/{commentId}")
    public String  getComments(@PathParam("messageId") Long messageId, @PathParam("commentId") Long CommentId) {
        
       return "return data => "+messageId +" , commentId => "+CommentId ;
    }
    
   
}
