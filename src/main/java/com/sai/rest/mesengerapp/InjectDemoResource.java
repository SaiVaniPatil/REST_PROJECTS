/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sai.rest.mesengerapp;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author saipati
 */
@Path("injectDemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemoResource {
    
    @GET
    @Path("annotations")
    public String getParamsUsingAnnotation(@MatrixParam("param") String matrix,@HeaderParam("authSessionID")
    String headerParam, @CookieParam("name") String cookie )
    {
        return "Matrix Param is "+matrix +"\n headerParam is "+headerParam+"\n cookieParam is "+cookie;
    }
    
     @GET
    @Path("context")
    public String getParamsUsingContext(@Context UriInfo uriInfo,@Context HttpHeaders httpHeaders)
    {
        
        String path = uriInfo.getAbsolutePath().toString();
        String cookies = httpHeaders.getCookies().toString();
        return "path is => "+path+"\n cookies => "+cookies;
    }
    
    
}
