/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sai.rest.mesengerapp;


import com.sai.rest.mesengerapp.model.Message;
import com.sai.rest.mesengerapp.service.MessageService;
import java.util.List;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author saipati
 */
@Path("messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResourceV2 {

    MessageService messageService = new MessageService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> getMessages(@BeanParam MessageFilterBean filterBean) {
        
        if(filterBean.getYear()>0)
        {
            return messageService.getAllMessagesInaYear(filterBean.getYear());
        }
        if(filterBean.getStart()>0 && filterBean.getSize()>0)
        {
            return messageService.getRangeOfMessages(filterBean.getStart(), filterBean.getSize());
        }
        return messageService.getAllMessages();
    }

    
    
//       @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<Message> getMessages(@QueryParam("year") int year,@QueryParam("start") int start,
//            @QueryParam("size") int size) {
//        
//        if(year>0)
//        {
//            return messageService.getAllMessagesInaYear(year);
//        }
//        if(start>0 && size>0)
//        {
//            return messageService.getRangeOfMessages(start, size);
//        }
//        return messageService.getAllMessages();
//    }
    
    @GET
    @Path("/{messageId}")

    public Message getMessage(@PathParam("messageId") long messageId,@ContextParam UriInfo uriInfo) {
         Message newMessage = messageService.getMessage(messageId);
         
         String uri = uriInfo.getBaseUriBuilder()
                 .path(MessageResourceV2.class)
                 .path(Long.toString(messageId))
                 .build()
                 .toString();
         newMessage.addLink(uri, "self");
         
       newMessage.addLink("www.google.com", "child");
         
         if(newMessage==null)
         {
            // throw new NoDataFoundException("Message with id" + messageId+" is not found");
             
         }
        return newMessage;

    }

    @POST

    public Response addMessage(Message msg) {
        
        Message newMessage = messageService.addMessage(msg);
       return  Response.status(Response.Status.CREATED).entity(newMessage).build();
       // return messageService.addMessage(msg);

    }

    @PUT
    @Path("/{messageId}")

    public Message updateMessage(@PathParam("messageId") long messageId, Message msg) {
        msg.setId(messageId);
        return messageService.updateMessage(msg);

    }

    @DELETE
    @Path("/{messageId}")

    public void updateMessage(@PathParam("messageId") long messageId) {

        messageService.removeMessage(messageId);

    }
    
    
    
    @Path("/{messageId}/comments")

    public CommentResource getCommentResource(@PathParam("messageId") long messageId) {
        return new CommentResource();

    }

}
