/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.personal.balogness.repository;

import com.personal.balogness.model.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author USER
 */
public interface Airplanearepo extends JpaRepository <Airplane,String> {
    
}
