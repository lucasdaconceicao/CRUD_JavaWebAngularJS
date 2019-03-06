/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.controllers;

import com.backend.infra.UsuariosDAO;
import com.backend.model.Usuarios;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author lucas
 */
@Path("usuarios")
public class UsuariosController {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    public List<Usuarios> listUsuarios(){
        try {
            UsuariosDAO usuariosDAO=new UsuariosDAO();
            return usuariosDAO.listar();
        } catch (Exception ex) {
            Logger.getLogger(UsuariosController.class.getName()).log(Level.SEVERE,null,ex);
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}/")
    public Usuarios getUsuario(@PathParam("id") int id){
        try {
            UsuariosDAO usuariosDAO=new UsuariosDAO();
            return usuariosDAO.selecionar(id);
        }
        catch (Exception ex) {
            Logger.getLogger(UsuariosController.class.getName()).log(Level.SEVERE,null,ex);
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response create(Usuarios usuario){
        try {
            UsuariosDAO usuariosDAO=new UsuariosDAO();
            usuariosDAO.inserir(usuario);
            return Response.status(Response.Status.OK).build();
        } catch (Exception ex) {
            Logger.getLogger(UsuariosController.class.getName()).log(Level.SEVERE,null,ex);
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response update(Usuarios usuario){
        try {
            UsuariosDAO usuariosDAO=new UsuariosDAO();
            usuariosDAO.alterar(usuario);
            return Response.status(Response.Status.OK).build();
        } catch (Exception ex) {
            Logger.getLogger(UsuariosController.class.getName()).log(Level.SEVERE,null,ex);
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
    @DELETE
    @Path("{id}/")
    public Response delete(@PathParam("id") int id){
        try {
            UsuariosDAO usuariosDAO=new UsuariosDAO();
            usuariosDAO.excluir(id);
            return Response.status(Response.Status.OK).build();
        } catch (Exception ex) {
            Logger.getLogger(UsuariosController.class.getName()).log(Level.SEVERE,null,ex);
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
}
 