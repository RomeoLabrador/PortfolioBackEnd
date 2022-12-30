/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.romeo.Service;

import com.portfolio.romeo.Entity.Presentacion;
import com.portfolio.romeo.Repository.RPresentacion;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SPresentacion {
    
    @Autowired
    
    RPresentacion rPresentacion;
    
    public List<Presentacion> list(){
        return rPresentacion.findAll();
    } 
    
    public Optional<Presentacion> getOne(int id){
        return rPresentacion.findById(id);
    }
    
    public Optional<Presentacion> getByNombre(String nombre){
        return rPresentacion.findByNombre(nombre);
    }
    
    public void save(Presentacion presentacion){
        rPresentacion.save(presentacion);
    }
    
    public void delete(int id){
        rPresentacion.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rPresentacion.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return rPresentacion.existsByNombre(nombre);
    }
    
}
