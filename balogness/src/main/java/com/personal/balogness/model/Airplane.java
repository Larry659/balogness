/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.personal.balogness.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author USER
 */
@Entity
@Table(name = "airplane")
@NamedQueries({
    @NamedQuery(name = "Airplane.findAll", query = "SELECT a FROM Airplane a"),
    @NamedQuery(name = "Airplane.findByRegistrationNumber", query = "SELECT a FROM Airplane a WHERE a.registrationNumber = :registrationNumber"),
    @NamedQuery(name = "Airplane.findByModelNumber", query = "SELECT a FROM Airplane a WHERE a.modelNumber = :modelNumber"),
    @NamedQuery(name = "Airplane.findByCapacity", query = "SELECT a FROM Airplane a WHERE a.capacity = :capacity")})
public class Airplane implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "RegistrationNumber")
    private String registrationNumber;
    @Column(name = "ModelNumber")
    private String modelNumber;
    @Column(name = "Capacity")
    private Short capacity;
    @OneToMany(mappedBy = "registrationNumber")
    private List<Flight> flightList;

    public Airplane() {
    }

    public Airplane(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public Short getCapacity() {
        return capacity;
    }

    public void setCapacity(Short capacity) {
        this.capacity = capacity;
    }

    public List<Flight> getFlightList() {
        return flightList;
    }

    public void setFlightList(List<Flight> flightList) {
        this.flightList = flightList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (registrationNumber != null ? registrationNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Airplane)) {
            return false;
        }
        Airplane other = (Airplane) object;
        if ((this.registrationNumber == null && other.registrationNumber != null) || (this.registrationNumber != null && !this.registrationNumber.equals(other.registrationNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.personal.balogness.model.Airplane[ registrationNumber=" + registrationNumber + " ]";
    }
    
}
