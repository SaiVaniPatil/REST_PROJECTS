/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sai.rest.mesengerapp.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author saipati
 */
@Provider
public class NoDataFoundException extends RuntimeException implements ExceptionMapper<NoDataFoundException> {
    @Override
    public Response toResponse(NoDataFoundException e) {
        return Response.status(Status.NOT_FOUND).build(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
