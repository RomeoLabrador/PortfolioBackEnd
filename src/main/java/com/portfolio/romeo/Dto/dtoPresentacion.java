/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.romeo.Dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author romeo
 */
public class dtoPresentacion {
    @NotBlank
    private String nombre;
    @NotBlank
    private String descripcion;
    
    //Constructores

    public dtoPresentacion() {
    }

    public dtoPresentacion(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    
    //getters and setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
    
}