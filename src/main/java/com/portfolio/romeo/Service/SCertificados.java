/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.romeo.Service;

import com.portfolio.romeo.Entity.Certificados;
import com.portfolio.romeo.Repository.RCertificados;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SCertificados {
    
    @Autowired
    RCertificados rCertificados;
    
    public List<Certificados> list(){
        return rCertificados.findAll();
    } 
    
    public Optional<Certificados> getOne(int id){
        return rCertificados.findById(id);
    }
    
    public Optional<Certificados> getByNombreC(String nombreE){
        return rCertificados.findByNombreC(nombreE);
    }
    
    public void save(Certificados certificados){
        rCertificados.save(certificados);
    }
    
    public void delete(int id){
        rCertificados.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rCertificados.existsById(id);
    }
    
    public boolean existsByNombreC(String nombreC){
        return rCertificados.existsByNombreC(nombreC);
    }
}

