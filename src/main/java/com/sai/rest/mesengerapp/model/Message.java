/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sai.rest.mesengerapp.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author saipati
 */
@XmlRootElement
public class Message {

    private String message;
    private long id;
    private String author;
    private List<Link> links= new ArrayList<Link>();

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    private Date created;

    public Message() {
    }

    public Message(long id, String message, String author) {
        this.message = message;
        this.id = id;
        this.created = new Date();
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Message(long id, Date created, String author) {
        this.id = id;
        this.created = created;
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    
    public void addLink(String url,String rel)
    {
        Link link = new Link();
        link.setLink(url);
        link.setRel(rel);
        links.add(link);
    }

}
