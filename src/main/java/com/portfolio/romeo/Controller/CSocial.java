/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.romeo.Controller;

import com.portfolio.romeo.Dto.dtoSocial;
import com.portfolio.romeo.Entity.Social;
import com.portfolio.romeo.Security.Controller.Mensaje;
import com.portfolio.romeo.Service.SSocial;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/social")
@CrossOrigin(origins = "http://localhost:4200")
public class CSocial {
    
    @Autowired
    SSocial sSocial;
    
    
    //METODOS
    
    @GetMapping("/lista")
    public ResponseEntity<List<Social>> list(){
        List<Social> list = sSocial.list();
        return new ResponseEntity(list,HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoSocial dtosocial){
        
        Social social = new Social(dtosocial.getGithub(),dtosocial.getLinkedin());
        sSocial.save(social);
        
        return new ResponseEntity(new Mensaje("Social Creado"),HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id,@RequestBody dtoSocial dtosocial){
        if(!sSocial.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el id"), HttpStatus.NOT_FOUND);
        }
        
        
        
        Social social = sSocial.getOne(id).get();
        
        social.setGithub(dtosocial.getGithub());
        social.setLinkedin(dtosocial.getLinkedin());
        
        sSocial.save(social);
        
        return new ResponseEntity(new Mensaje("Presentacion actualizada"), HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Social> getById(@PathVariable("id")int id){
        if(!sSocial.existsById(id))
            return new ResponseEntity(new Mensaje("no existe la id"), HttpStatus.NOT_FOUND);
        Social social = sSocial.getOne(id).get();
        return new ResponseEntity(social, HttpStatus.OK);
    }
}
