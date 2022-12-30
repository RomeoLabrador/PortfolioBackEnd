/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.romeo.Service;

import com.portfolio.romeo.Entity.Social;
import com.portfolio.romeo.Repository.RSocial;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SSocial {
    
    @Autowired
    
    RSocial rSocial;
    
    public List<Social> list(){
        return rSocial.findAll();
    } 
    
    public Optional<Social> getOne(int id){
        return rSocial.findById(id);
    }
    
    public Optional<Social> getByGithub(String Github){
        return rSocial.findByGithub(Github);
    }
    
    public Optional<Social> getByLinkedin(String Linkedin){
        return rSocial.findByGithub(Linkedin);
    }
    
    public void save(Social social){
        rSocial.save(social);
    }
    
    public void delete(int id){
        rSocial.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rSocial.existsById(id);
    }
    
    public boolean existsByGithub(String github){
        return rSocial.existsByGithub(github);
    }
    
    public boolean existsByLinkedin(String linkedin){
        return rSocial.existsByGithub(linkedin);
    }
    
}