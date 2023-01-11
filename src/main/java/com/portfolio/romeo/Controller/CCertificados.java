/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.romeo.Controller;

import com.portfolio.romeo.Dto.dtoCertificados;
import com.portfolio.romeo.Entity.Certificados;
import com.portfolio.romeo.Security.Controller.Mensaje;
import com.portfolio.romeo.Service.SCertificados;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/certificados")
@CrossOrigin(origins = "https://portfoliofrontend-dec42.web.app")
public class CCertificados {
    
    @Autowired
    SCertificados sCertificados;
    
    //METODOS
    
    @GetMapping("/lista")
    public ResponseEntity<List<Certificados>> list(){
        List<Certificados> list = sCertificados.list();
        return new ResponseEntity(list,HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sCertificados.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el Id"), HttpStatus.NOT_FOUND);
        }
        sCertificados.delete(id);
        return new ResponseEntity(new Mensaje("Certificado Eliminado"),HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoCertificados dtocertificados){
        if(StringUtils.isBlank(dtocertificados.getNombreC()))
            return new ResponseEntity(new Mensaje("El nombre es OBLIGATORIO"), HttpStatus.BAD_REQUEST);
        if(sCertificados.existsByNombreC(dtocertificados.getNombreC()))
            return new ResponseEntity(new Mensaje("Ese Estudio ya existe"), HttpStatus.BAD_REQUEST);
        Certificados certificado = new Certificados(dtocertificados.getNombreC(),dtocertificados.getDescripcionC());
        sCertificados.save(certificado);
        
        return new ResponseEntity(new Mensaje("Estudio Agregada"),HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id,@RequestBody dtoCertificados dtocertificados){
        if(!sCertificados.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el id"), HttpStatus.NOT_FOUND);
        }
        if(sCertificados.existsByNombreC(dtocertificados.getNombreC()) && sCertificados.getByNombreC(dtocertificados.getNombreC()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"),HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtocertificados.getNombreC())){
            return new ResponseEntity(new Mensaje("el campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
        Certificados certificados = sCertificados.getOne(id).get();
        
        certificados.setNombreC(dtocertificados.getNombreC());
        certificados.setDescripcionC(dtocertificados.getDescripcionC());
        
        sCertificados.save(certificados);
        
        return new ResponseEntity(new Mensaje("educacion actualizada"), HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Certificados> getById(@PathVariable("id")int id){
        if(!sCertificados.existsById(id))
            return new ResponseEntity(new Mensaje("no existe la id"), HttpStatus.NOT_FOUND);
        Certificados certificados = sCertificados.getOne(id).get();
        return new ResponseEntity(certificados, HttpStatus.OK);
    }
    
}
