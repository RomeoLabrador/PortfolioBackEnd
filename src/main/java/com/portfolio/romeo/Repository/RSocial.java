/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.romeo.Repository;

import com.portfolio.romeo.Entity.Social;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author romeo
 */
public interface RSocial extends JpaRepository<Social, Integer>{
    public Optional<Social> findByGithub(String nombreH);
    public boolean existsByGithub(String nombreH);
    public Optional<Social> findByLinkedin(String nombreH);
    public boolean existsByLinkedin(String nombreH);
    
}
