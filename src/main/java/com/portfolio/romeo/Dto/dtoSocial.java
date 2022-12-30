/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.romeo.Dto;


public class dtoSocial {
    public String github;
    public String linkedin;
    
    //Constructores

    public dtoSocial() {
    }
    
    

    public dtoSocial(String github, String linkedin) {
        this.github = github;
        this.linkedin = linkedin;
    }
    
    //getters and setters

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }
    
    
    
    
    
}
