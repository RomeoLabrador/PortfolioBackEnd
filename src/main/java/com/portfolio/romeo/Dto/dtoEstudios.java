/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.romeo.Dto;

import javax.validation.constraints.NotBlank;


public class dtoEstudios {
    @NotBlank
    private String nombreE;
    @NotBlank
    private String DescripcionE;
    private String img;

    public dtoEstudios() {
    }

    public dtoEstudios(String nombreE, String DescripcionE, String img) {
        this.nombreE = nombreE;
        this.DescripcionE = DescripcionE;
        this.img = img;
    }
    
    //getter and setter

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getDescripcionE() {
        return DescripcionE;
    }

    public void setDescripcionE(String DescripcionE) {
        this.DescripcionE = DescripcionE;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
    
    
}
