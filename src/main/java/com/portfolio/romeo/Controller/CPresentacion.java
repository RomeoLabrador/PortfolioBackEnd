/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.romeo.Controller;

import com.portfolio.romeo.Dto.dtoPresentacion;
import com.portfolio.romeo.Entity.Presentacion;
import com.portfolio.romeo.Security.Controller.Mensaje;
import com.portfolio.romeo.Service.SPresentacion;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/presentacion")
@CrossOrigin(origins = "https://portfoliofrontend-dec42.web.app")

    
public class CPresentacion {
    @Autowired
    SPresentacion sPresentacion;
    
    //Metodos
    
    @GetMapping("/lista")
    public ResponseEntity<List<Presentacion>> list(){
        List<Presentacion> list = sPresentacion.list();
        return new ResponseEntity(list,HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sPresentacion.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el Id"), HttpStatus.NOT_FOUND);
        }
        sPresentacion.delete(id);
        return new ResponseEntity(new Mensaje("Presentacion Eliminada"),HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoPresentacion dtopresentacion){
        if(StringUtils.isBlank(dtopresentacion.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es OBLIGATORIO"), HttpStatus.BAD_REQUEST);
        if(sPresentacion.existsByNombre(dtopresentacion.getNombre()))
            return new ResponseEntity(new Mensaje("Esa presentacion ya existe"), HttpStatus.BAD_REQUEST);
        Presentacion presentacion = new Presentacion(dtopresentacion.getNombre(),dtopresentacion.getDescripcion(),dtopresentacion.getImg());
        sPresentacion.save(presentacion);
        
        return new ResponseEntity(new Mensaje("Presentacion Agregada"),HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id,@RequestBody dtoPresentacion dtopresentacion){
        if(!sPresentacion.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el id"), HttpStatus.NOT_FOUND);
        }
        if(sPresentacion.existsByNombre(dtopresentacion.getNombre()) && sPresentacion.getByNombre(dtopresentacion.getNombre()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"),HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtopresentacion.getNombre())){
            return new ResponseEntity(new Mensaje("el campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
        Presentacion presentacion = sPresentacion.getOne(id).get();
        
        presentacion.setNombre(dtopresentacion.getNombre());
        presentacion.setDescripcion(dtopresentacion.getDescripcion());
        presentacion.setImg(dtopresentacion.getImg());
        
        sPresentacion.save(presentacion);
        
        return new ResponseEntity(new Mensaje("Presentacion actualizada"), HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Presentacion> getById(@PathVariable("id")int id){
        if(!sPresentacion.existsById(id))
            return new ResponseEntity(new Mensaje("no existe la id"), HttpStatus.NOT_FOUND);
        Presentacion presentacion = sPresentacion.getOne(id).get();
        return new ResponseEntity(presentacion, HttpStatus.OK);
    }
}
